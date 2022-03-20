package com.jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.entities.User;
import com.jpa.test.repos.UserRepository;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepo = context.getBean(UserRepository.class);

		User user = new User();
		user.setCity("Gurugram");
		user.setName("Naman");
		user.setStatus("Software Enginner");
//		System.out.println(user);
		User userResult = userRepo.save(user);
		System.out.println(userResult);
		System.out.println(userResult.getId());
//		ArrayList<User> ar = new ArrayList<User>() ;
//		ar.add(user);
//		userRepo.saveAll(ar);
		List<User> user1 = userRepo.findByName(userResult.getName());
		Optional<User> user2 = userRepo.findById(userResult.getId());
		
		System.out.println(user1);
		System.out.println(user2);
		
		((ConfigurableApplicationContext) context).close();
	}

}
