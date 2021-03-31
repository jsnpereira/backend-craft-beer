package com.craft.beer.model.converts;

import com.craft.beer.model.entity.User;
import com.craft.beer.model.request.UserRequest;

public class UserConvert {
	
	public static User convertToEntity(UserRequest userRequest) {
		User user = new User();
		user.setFristname(userRequest.getFirstname());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setCredential(userRequest.getCredential());
		return user;
	}
	
	public static UserRequest convertToRequest(User user) {
		UserRequest userRequest = new UserRequest();
		userRequest.setFristname(user.getFristname());
		userRequest.setLastName(user.getLastName());
		userRequest.setEmail(user.getEmail());
		userRequest.setCredential(user.getCredential());
		userRequest.setId(user.getId());
		return userRequest;
	}
	
	public static void update(User user, UserRequest userRequest) {
		user.setFristname(userRequest.getFirstname());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setCredential(userRequest.getCredential());	
	}

}
