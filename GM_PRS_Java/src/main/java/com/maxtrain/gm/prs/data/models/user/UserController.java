package com.maxtrain.gm.prs.data.models.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository UserR;
	
	
	@GetMapping
	public ResponseEntity<Iterable<User>> GetAllUsers(){
		Iterable<User> Users = UserR.findAll();
		return new ResponseEntity<Iterable<User>>(Users, HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<User> GetUserByID(@PathVariable int id){
		if(id<=0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> Users= UserR.findById(id);
		if(Users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(Users.get(), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<User> PostUser(@RequestBody User user){
		if(user.getId() != 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UserR.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@SuppressWarnings("rawtypes")
	@PutMapping("{id}")
	public ResponseEntity PutUser(@PathVariable int id, @RequestBody User user) {
		if(user.getId() != id) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UserR.save(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("{id}")
	public ResponseEntity DeleteUser(@PathVariable int id) {
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UserR.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

	@RequestMapping("{UN}/{PW}")
	public ResponseEntity<User> Login(@PathVariable String UN, @PathVariable String PW){
		Optional<User> U = UserR.findUserByUsernameAndPassword(UN,PW);
		if(U.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(U.get(),HttpStatus.OK);
		}
	}
	
	
	
}
