package com.craft.beer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.beer.model.request.UserRequest;
import com.craft.beer.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserRequest> create( @RequestBody UserRequest userRequest) {
		UserRequest uRequest = userService.save(userRequest);
		return new ResponseEntity<UserRequest>(uRequest, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserRequest>> getAllFinds() {
		List<UserRequest> list = userService.getAllFinds();
		return new ResponseEntity<List<UserRequest>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserRequest> getFindById(@PathVariable(value = "id") String id) {
		UserRequest userRequest = userService.getFindById(id);
		return new ResponseEntity<UserRequest>(userRequest, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserRequest> update(@PathVariable(value = "id") String id,
			@RequestBody UserRequest userRequest) {
		UserRequest usRequest = userService.update(id, userRequest);
		return new ResponseEntity<UserRequest>(usRequest, HttpStatus.ACCEPTED);

	}

}
