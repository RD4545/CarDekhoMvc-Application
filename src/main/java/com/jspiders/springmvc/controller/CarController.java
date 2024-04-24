package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.CarDto;
import com.jspiders.springmvc.dto.UserDto;
import com.jspiders.springmvc.service.CarService;
import com.jspiders.springmvc.service.UserService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping(path =  "/add",method = RequestMethod.GET)
//	public String getAdd(HttpSession httpSession) {
//		 if (httpSession.getAttribute("signedInUser") == null) {
//		        return "sign_in";
//		    }
//		return "add_car";
//	}
//	
//	@RequestMapping(path = "/add_car",method = {RequestMethod.GET,RequestMethod.POST})
//	public String addCar(@RequestParam(name = "name",required = false) String name,
//						 @RequestParam(name = "brand",required = false) String brand,
//						 @RequestParam(name = "price",required = false) double price,
//						 ModelMap map,
//						 HttpSession httpSession) {
//		
//		if(httpSession.getAttribute("signedInUser") == null) {
//			return "sign_in";
//		}
//		carService.addCar(name,brand,price);
//		map.addAttribute("message", "Car details added");
//		
//		return "add_car";
//	}
	
	@RequestMapping(path = "/add_car", method = {RequestMethod.GET, RequestMethod.POST})
	public String addCar(@RequestParam(name = "name" ,required = false) String name,  // default required is true  
	                     @RequestParam(name = "brand",required = false) String brand,// so it can throw exception
	                     @RequestParam(name = "price",required = false) Double price,
	                     ModelMap map,HttpSession httpSession) {

		if(httpSession.getAttribute("signedInUser") == null) {
			return "sign_in";
		}
		UserDto user= (UserDto) httpSession.getAttribute("signedInUser");
	    if (name != null && brand != null && price != null) {
	        // Parameters are present, process the for m submission
	        CarDto addedCar= carService.addCar(name, brand, price);
	        userService.updateUser(user,addedCar);
	       
	        map.addAttribute("message", "Car details added");
	        return "add_car"; // Return the view for adding a car (GET request)
	    } else {
	        // Parameters are missing, return the add car form
	        return "add_car"; // Return the view for adding a car (GET request)
	    }
	}

	
	@RequestMapping(path = "/show_cars",method = RequestMethod.GET)
	public String  getCars(ModelMap map,HttpSession httpSession) {
		
			UserDto signInUser =(UserDto) httpSession.getAttribute("signedInUser");
			if(signInUser != null) {
				List<CarDto> cars = carService.showcars();
				map.addAttribute("message", cars);
			
				return "show_cars";
			}
			else {
				return "sign_in";
			}
			
		
	}
//	
//	@RequestMapping(path = "/delete_car",method = {RequestMethod.GET,RequestMethod.POST})
//	public String deleteCar(@RequestParam(name = "name",required = false) String name,ModelMap map,HttpSession httpSession) {
//		List<CarDto> cars = carService.showcars();
//		
//
//		if(httpSession.getAttribute("signedInUser") == null) {
//			return "sign_in";
//		}
//	
//		carService.deleteCar(name);
//		if(name != null) {
//			map.addAttribute("msg", "car deleted success");
//		}
//		map.addAttribute("message",cars);
//		
//		
//		return "delete_car";
//		
//	}
	
	@RequestMapping("/my_cars")
	public String findCarsByUser(ModelMap map ,HttpSession httpSession) {
		UserDto signedInUser = (UserDto) httpSession.getAttribute("signedInUser");
		
		if(signedInUser != null) {
			List<CarDto> cars = carService.findCarsByUser(signedInUser);
			if(cars != null) {
				map.addAttribute("cars", cars);
			}
			else {
				map.addAttribute("message","cars not found");
			}
			return "my_cars";
		}
		else {
			return "sign_in";
		}
	}
	
	@RequestMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@RequestMapping(path = "/delete_car" , method = RequestMethod.POST)
	public String deleteCar(@RequestParam(name = "carId") int id , ModelMap map ,HttpSession httpSession) {
		
		UserDto user =(UserDto) httpSession.getAttribute("signedInUser");
		carService.deletCar(user, id);
		List<CarDto> cars = carService.findCarsByUser(user);
		if(cars != null) {
			map.addAttribute("cars",cars);
			map.addAttribute("message","Car Deleted");
		}
		else {
			map.addAttribute("message","cars not available");
		}
		return "my_cars";
	}
	
	
	@RequestMapping(path = "/update_car",method = RequestMethod.POST)
	public String updateCar(@RequestParam(name = "id") int id, @RequestParam(name = "name")  String name, 
							@RequestParam(name = "brand")  String brand, 
							@RequestParam(name = "price")  double price, 
							ModelMap map ,HttpSession httpSession) {
		
		UserDto user = (UserDto)httpSession.getAttribute("signedInUser");
		carService.updateCar(id,name,brand,price);
		List<CarDto> cars = carService.findCarsByUser(user);
		map.addAttribute("cars",cars);
		map.addAttribute("message","car updated");
		
		
		return "my_cars";
	}
	
	
	@RequestMapping(path = "/edit_car",method = RequestMethod.POST)
	public String editPage(@RequestParam(name = "id") int id,ModelMap map) {
		
		CarDto car = carService.findCarById(id);
		map.addAttribute("car", car);
		
		return "edit_car";
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String findAllCarsByPrice(@RequestParam(name = "low") double low, @RequestParam(name = "high") double high,
			ModelMap modelMap) {
		List<CarDto> cars = carService.findAllCarsByPrice(low, high);
		if (cars != null) {
			modelMap.addAttribute("message", cars);
		} else {
			modelMap.addAttribute("message", "Cars not available");
		}
		return "show_cars";
	}
	

}
