package com.maxtrain.gm.prs.data.models.vendor;

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
@RequestMapping("/api/vendors")
public class VendorController {
	@Autowired
	private VendorRepository VendR;
	
	@GetMapping
	public ResponseEntity<Iterable<Vendor>> GetAllVendors(){
		Iterable<Vendor> Vends = VendR.findAll();
		return new ResponseEntity<Iterable<Vendor>>(Vends, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Vendor> GetVendorByID(@PathVariable int id){
		if(id<=0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Vendor> Vend= VendR.findById(id);
		if(Vend.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vendor>(Vend.get(), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Vendor> PostVendor(@RequestBody Vendor Vend){
		if(Vend.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		VendR.save(Vend);
		return new ResponseEntity<>(Vend, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity PutVendor(@PathVariable int id, @RequestBody Vendor Vend) {
		if(Vend.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		VendR.save(Vend);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity DeleteVendor(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		VendR.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
