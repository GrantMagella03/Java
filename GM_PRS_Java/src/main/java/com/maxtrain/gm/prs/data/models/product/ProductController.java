package com.maxtrain.gm.prs.data.models.product;

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
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductRepository PR;
	
	
	@GetMapping
	public ResponseEntity<Iterable<Product>> GetAllProducts(){
		Iterable<Product> Prods = PR.findAll();
		return new ResponseEntity<Iterable<Product>>(Prods, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<Product> GetProductByID(@PathVariable int id){
		if(id<=0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Product> Prod = PR.findById(id);
		if(Prod.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(Prod.get(), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Product> PostProduct(@RequestBody Product Prod){
		if(Prod.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		PR.save(Prod);
		return new ResponseEntity<>(Prod, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity PutProduct(@PathVariable int id, @RequestBody Product Prod) {
		if(Prod.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		PR.save(Prod);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity DeleteProduct(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		PR.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}
