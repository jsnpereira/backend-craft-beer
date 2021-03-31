package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.converts.UserConvert;
import com.craft.beer.model.entity.User;
import com.craft.beer.model.request.UserRequest;
import com.craft.beer.repository.UserRepository;

@Service
public class UserService {
	private String ID_NOT_FOUND = "User ID[XXX] not found in our databse";

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public UserRequest save(UserRequest userRequest) {
		User user = userRepository.save(UserConvert.convertToEntity(userRequest));
		return UserConvert.convertToRequest(user);
	}

	public List<UserRequest> getAllFinds() {
		List<User> users = userRepository.findAll();
		List<UserRequest> list = new ArrayList<>();
		for (User user : users) {
			list.add(UserConvert.convertToRequest(user));
		}
		return list;
	}

	public UserRequest getFindById(String id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id)));
		return UserConvert.convertToRequest(user);
	}

	public UserRequest update(String id, UserRequest userRequest) {
		Optional<User> user = Optional.of(userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id))));
		if (user.isPresent()) {
			UserConvert.update(user.get(), userRequest);
			userRepository.save(user.get());
			userRequest.setId(user.get().getId());
		}
		return userRequest;
	}

}
