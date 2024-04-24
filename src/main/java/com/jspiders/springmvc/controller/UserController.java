package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.UserDto;
import com.jspiders.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(path = "/get_page" , method = RequestMethod.GET)
	public String getSignPage() {
		
		return "sign_up";
	}
	
	@RequestMapping(path =  "/sign_in",method = RequestMethod.GET)
	public String getSign() {
		return "sign_in";
	}
	
	@RequestMapping(path = "/add_user",method = RequestMethod.POST)
	public String addUser(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,ModelMap map) {
		
		UserDto addedUser = service.addUser(email,password);
		
		if(addedUser != null) {
			map.addAttribute("message","signed up");
			return "sign_in";
		}
		else {
			map.addAttribute("message", "Email Already Exists");
			return "sign_up";
		}
			
		
	}
	
	@RequestMapping( path =  "/check_user" ,method = RequestMethod.POST)
	public String checkUser(@RequestParam(name = "email") String email, 
			@RequestParam(name = "password") String password,ModelMap map,HttpSession httpSession)  {
		
		UserDto signedInUser = service.checkUser(email,password);
		httpSession.setAttribute("signedInUser",signedInUser);
		if(signedInUser != null) {
			
			System.out.println("home");
			return "home";
		}
		else {
			map.addAttribute("message","invalid email or password");
			return "sign_in";
		}
		
		
	}
	
	@RequestMapping(path = "/sign_out")
	public String signOut(HttpSession httpSession) {
		if(httpSession.getAttribute("signedInUser") != null) {
			httpSession.invalidate();
		}
		return "sign_in";
		
	}
	
	

	
	
	
	
}
