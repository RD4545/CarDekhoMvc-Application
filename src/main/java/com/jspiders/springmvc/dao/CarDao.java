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
public class CarDao {

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
	
	public void addCar(CarDto carDto) {
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(carDto);
		
		
		entityTransaction.commit();
		closeConnection();
	}

	public List<CarDto> showcars() {
		openConnection();
		entityTransaction.begin();
		
		Query query =entityManager.createQuery("select car from CarDto car");
		@SuppressWarnings("unchecked")
		List<CarDto> cars = query.getResultList();
		
		entityTransaction.commit();
		closeConnection();
		
		return cars;
		
	}
//
//	public void deleteCar(String name) {
//		
//		openConnection();
//		entityTransaction.begin();
//		
//		Query query = entityManager.createQuery("delete from CarDto c where c.name = :name").setParameter("name", name);
//		
//		int i = query.executeUpdate();
//
//	    if (i > 0) {
//	        System.out.println("Car with name '" + name + "' deleted successfully.");
//	    } else {
//	        System.out.println("Car with name '" + name + "' not found.");
//	    }
//
//	   
//		entityTransaction.commit();
//		closeConnection();
//		
//	}

	public List<CarDto> findCarsByUser(int id) {
		openConnection();
		
		UserDto user = entityManager.find(UserDto.class ,id);
		List<CarDto> cars = user.getCars();
		
		closeConnection();
		
		return cars;
		
	} 
	
	
	public void deletCar(int userId,int carId) {
		
		openConnection();
		
		UserDto user = entityManager.find(UserDto.class, userId);
		List<CarDto> cars = user.getCars();
		
		CarDto cartobeDeleted = null;
		for(CarDto car : cars) {
			if(car.getId() == carId) {
				cartobeDeleted = car;
				break;
			}
		}
		
		cars.remove(cartobeDeleted);
		user.setCars(cars);
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		CarDto car = entityManager.find(CarDto.class, carId);
		
		entityTransaction.begin();
		entityManager.remove(car);
		entityTransaction.commit();
		
		
		closeConnection();
		
	}

	public void deleteCarById(int id, int id2) {
		// TODO Auto-generated method stub
		
	}

	public CarDto findCarById(int id) {
		openConnection();
		CarDto car = entityManager.find(CarDto.class, id);
		closeConnection();
		return car;
		
	}

	public void updateCar(CarDto car) {
		openConnection();
		CarDto carToBeUpdated = entityManager.find(CarDto.class, car.getId());
		carToBeUpdated.setName(car.getName());
		carToBeUpdated.setBrand(car.getBrand());
		carToBeUpdated.setPrice(car.getPrice());
		
		entityTransaction.begin();
		entityManager.persist(carToBeUpdated);
		entityTransaction.commit();
		
		closeConnection();
		
	}

	public List<CarDto> findAllCarsByPrice(double low, double high) {
		openConnection();
		Query query = entityManager.createQuery("SELECT car FROM CarDto car WHERE price BETWEEN ?1 AND ?2 ");
		query.setParameter(1, low);
		query.setParameter(2, high);
		@SuppressWarnings("unchecked")
		List<CarDto> cars = query.getResultList();
		return cars;
	}
	
	
}
