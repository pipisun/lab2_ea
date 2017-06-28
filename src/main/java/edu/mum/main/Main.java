package edu.mum.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import edu.mum.service.impl.UserServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		
		User user = new User();
		user.setAdmin(false);
		user.setEmail("Sean@Cookies.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setRanking(1);
		user.setVersion(1);
		
		userService.save(user);
		
		User finduser = userService.findByEmail("Sean@Cookies.com");
		System.out.println();
        System.out.println("        *********  User **********");
		System.out.println("User Name:" + finduser.getFirstName() + " " + finduser.getLastName());
	}  
}