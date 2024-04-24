package com.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dto.CarDto;
import com.jspiders.springmvc.dto.UserDto;


@Component
public class UserDao {

	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
	}
	
	private static void closeConnection() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		
		if(entityManager != null) {
			entityManager.close();
		}
		
		if(entityTransaction != null) {
			
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			
			
		}
	}
	
	public UserDto addUser(UserDto userDto) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(userDto);
		
		entityTransaction.commit();
		closeConnection();
		return userDto;
	}

	public List<UserDto> findAllUsers() {
		
		openConnection();
		
		Query query = entityManager.createQuery("select user from UserDto user");
		
		@SuppressWarnings("unchecked")
		List<UserDto> users = query.getResultList();
		
		
		closeConnection();
		
		return users;
	}

	public void updateUser(int userId, int carId) {
		openConnection();
		
		UserDto user = entityManager.find(UserDto.class,userId);
		CarDto car = entityManager.find(CarDto.class, carId);
		
		List<CarDto> cars = user.getCars();
		cars.add(car);
		user.setCars(cars);
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		closeConnection();
		
	}


}
