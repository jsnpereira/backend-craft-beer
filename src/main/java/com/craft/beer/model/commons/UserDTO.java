package com.craft.beer.model.commons;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.craft.beer.model.entity.User;
import com.craft.beer.model.request.UserRequest;

public class UserDTO {
	
	public static User convertToEntity(UserRequest userRequest) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userRequest, User.class);
		return user;
	}
	
	public static UserRequest convertToRequest(User user) {
		ModelMapper modelMapper = new ModelMapper();
		UserRequest userRequest = modelMapper.map(user, UserRequest.class);
		return userRequest;
	}
	
}
