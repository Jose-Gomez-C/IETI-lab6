package edu.escuelaing.ieti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.ieti.model.User;
import edu.escuelaing.ieti.services.UserService;
	
@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	UserService user;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<>(user.getAll(), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id){
		return new ResponseEntity<>(user.getById(id), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<?> createUser(@RequestBody  User newUser){
		return new ResponseEntity<> (user.create(newUser), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public ResponseEntity<?> updateUser(@RequestBody User newUser){
		return new ResponseEntity<>(user.update(newUser), HttpStatus.ACCEPTED);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/remove/{userId}")
	public ResponseEntity<?> removeUser(@PathVariable String userId) {
		user.remove(userId);
		return new ResponseEntity<>( HttpStatus.ACCEPTED);
	}
}
