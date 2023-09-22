package com.maxtrain.gm.prs.data.models.Request;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/requests")
public class RequestController {
	@Autowired
	private RequestRepository ReqR;
	
	@GetMapping
	public ResponseEntity<Iterable<Request>> GetAllRequests(){
		Iterable<Request> Reqs = ReqR.findAll();
		return new ResponseEntity<Iterable<Request>>(Reqs, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Request> GetRequestByID(@PathVariable int id){
		if(id<=0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Request> Req = ReqR.findById(id);
		if(Req.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Request>(Req.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Request> PostRequest(@RequestBody Request Req){
		if(Req.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ReqR.save(Req);
		return new ResponseEntity<>(Req, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity PutRequest(@PathVariable int id, @RequestBody Request Req) {
		if(Req.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ReqR.save(Req);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity DeleteRequest(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ReqR.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	@SuppressWarnings("rawtypes")
	@PutMapping("reject/{id}")
	public ResponseEntity Reject(@PathVariable int id, @RequestBody Request Req){
		if(Req.getRejectionReason() == null || Req.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Req.setStatus("REJECTED");
			ReqR.save(Req);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("review/{id}")
	public ResponseEntity review(@PathVariable int id, @RequestBody Request Req){
		if(Req.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			if(Req.getTotal()<=50.0) {
				Req.setStatus("APPROVED");
			} else {
				Req.setStatus("REVIEW");
			}
			ReqR.save(Req);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("approve/{id}")
	public ResponseEntity Approve(@PathVariable int id, @RequestBody Request Req){
		if(Req.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			Req.setStatus("APPROVED");
			ReqR.save(Req);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@GetMapping("reviews/{UID}")
	public ResponseEntity<Iterable<Request>> GetReviews(@PathVariable int UID){
		Iterable<Request> AllReqs = GetAllRequests().getBody();
		ArrayList<Request> ReqL = new ArrayList<Request>();
		for(Request R : AllReqs) {
			if(R.getUser().getId() != UID && R.getStatus().toUpperCase().equals("REVIEW")) {
				ReqL.add(R);
			}
		}
		Iterable<Request> FReqs = ReqL;
		return new ResponseEntity<Iterable<Request>>(FReqs,HttpStatus.OK) ;
	}

}
