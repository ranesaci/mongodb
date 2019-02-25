package com.sachin.mongodbtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.mongodbtest.model.User;
import com.sachin.mongodbtest.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@GetMapping("test")
	public String test() {
		return "Hello!!!";
	}
	
	@RequestMapping("save")
	public void save() {
		
		User user = new User();
		user.setFname("sachin11");
		user.setLname("Rane11");
		
		userRepository.save(user);
	}
	
	@GetMapping("fetch")
	public List<User> retrieveUser() {
		
		return userRepository.findAll();
		
	}
	
	@GetMapping("regex")
	public List<User> regexUser() {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("fname").regex("sachin1"));
		
		List<User> users = mongoOperations.find(query, User.class);
		
		return users;
		
	}
	
	

}
