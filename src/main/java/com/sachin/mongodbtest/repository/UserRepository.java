package com.sachin.mongodbtest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sachin.mongodbtest.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	
}