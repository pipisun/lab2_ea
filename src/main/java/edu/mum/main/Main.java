package edu.mum.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		UserService userService = (UserService)applicationContext.getBean("userServiceImpl");
		
		User user = userService.findByEmail("Sean@Cookies.com");
		System.out.println("User Name:" + user.getFirstName() + " " + user.getLastName());
     
	}  
}