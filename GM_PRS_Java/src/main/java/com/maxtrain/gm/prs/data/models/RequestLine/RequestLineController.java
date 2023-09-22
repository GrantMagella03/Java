package com.maxtrain.gm.prs.data.models.RequestLine;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api/requestlines")
public class RequestLineController {
	@Autowired
	private RequestLineControllerRepository RLCR;
	


	@GetMapping
	public ResponseEntity<Iterable<RequestLine>> GetAllRequestLines(){
		Iterable<RequestLine> ReqLs = RLCR.findAll();
		return new ResponseEntity<Iterable<RequestLine>>(ReqLs, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<RequestLine> GetRequestLineByID(@PathVariable int id){
		if(id<=0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RequestLine> ReqL = RLCR.findById(id);
		if(ReqL.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RequestLine>(ReqL.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<RequestLine> PostRequestLine(@RequestBody RequestLine ReqL){
		if(ReqL.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		int RID = ReqL.getRequest().getId();
		RLCR.save(ReqL);
		RecalculateRequestTotal(RID);
		return new ResponseEntity<>(ReqL, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity PutRequestLine(@PathVariable int id, @RequestBody RequestLine ReqL) {
		if(ReqL.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		int RID = ReqL.getRequest().getId();
		RLCR.save(ReqL);
		RecalculateRequestTotal(RID);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity DeleteRequestLine(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		int RID = GetRequestLineByID(id).getBody().getRequest().getId();
		RLCR.deleteById(id);
		RecalculateRequestTotal(RID);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	private void RecalculateRequestTotal(int RID) {
		Iterable<RequestLine> AllReqLs = GetAllRequestLines().getBody();
		double total = 0;
		for(RequestLine R : AllReqLs) {
			if(R.getRequest().getId() == RID) {
				total = total + (R.getProduct().getPrice() * R.getQuantity());
				R.getRequest().setTotal(total);
				RLCR.save(R);
			}
		}
		
	}
}
