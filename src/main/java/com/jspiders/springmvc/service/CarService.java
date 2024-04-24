package com.jspiders.springmvc.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.CarDao;
import com.jspiders.springmvc.dto.CarDto;
import com.jspiders.springmvc.dto.UserDto;

@Component
public class CarService {

	@Autowired
	private CarDao carDao;

	
	public CarDto addCar(String name,String brand,double price) {
		
		CarDto carDto = new CarDto();
		
		carDto.setName(name);
		carDto.setBrand(brand);
		carDto.setPrice(price);
		
		carDao.addCar(carDto);
		return carDto;
	}
	
	public List<CarDto> showcars(){
		
		return carDao.showcars();
	}

//	
//	public void deleteCar(String name) {
//		
//		carDao.deleteCar(name);
//		
//	}

	public List<CarDto> findCarsByUser(UserDto signedInUser) {
		List<CarDto> cars= carDao.findCarsByUser(signedInUser.getId());
		if(cars != null && cars.size()>0) {
			return cars;
		}
		else {
			return null;
		}
	}

	public void deletCar(UserDto user,int carid) {
		
		carDao.deletCar(user.getId(),carid);
		
	}

	public CarDto findCarById(int id) {
		
		return carDao.findCarById(id);
	}

	public void updateCar(int id, String name, String brand, double price) {
		CarDto car = new CarDto();
		car.setId(id);
		car.setName(name);
		car.setBrand(brand);
		car.setPrice(price);
		
		carDao.updateCar(car);
	}

	public List<CarDto> findAllCarsByPrice(double low, double high) {
		List<CarDto> cars = carDao.findAllCarsByPrice(low, high);
		if (cars != null && cars.size() > 0) {
			return cars;
		} else {
			return null;
		}
	}

	

	
	
}
