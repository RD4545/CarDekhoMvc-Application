package com.jspiders.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.UserDao;
import com.jspiders.springmvc.dto.CarDto;
import com.jspiders.springmvc.dto.UserDto;

@Component
public class UserService {

	@Autowired
	UserDao dao;

	public UserDto addUser(String email, String password) {


		UserDto addedUser = null;
		boolean userExist = false;
		
		List<UserDto> users = dao.findAllUsers();
		
		for(UserDto user : users) {
			if(user.getEmail().equals(email)) {
				userExist = true;
				break;
			}
		}
		if(!userExist) {
			UserDto user =new UserDto();
			user.setEmail(email);
			user.setPassword(password);
			user.setCars(new ArrayList<CarDto>());
			addedUser = dao.addUser(user);
		}
		return addedUser;
	}

	public UserDto checkUser(String email, String password) {
		List<UserDto> users = dao.findAllUsers();
		
		UserDto signedInUser = null;
		for(UserDto user : users) {
			
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				
				signedInUser = user;
				break;
			}
		}
		return signedInUser;		
	}

	public void updateUser(UserDto user, CarDto addedCar) {
		System.out.println(user.getId());
		System.out.println(addedCar.getId());
		dao.updateUser(user.getId(),addedCar.getId());
		
	}

	
}
