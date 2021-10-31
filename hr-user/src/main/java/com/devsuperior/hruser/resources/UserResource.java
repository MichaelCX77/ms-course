package com.devsuperior.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.services.UserService;


@RestController
@RequestMapping(value ="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		
		User user = service.findById(id);
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping(value ="/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		
		User user = service.findByEmail(email);
		return ResponseEntity.ok(user);
		
	}

}
