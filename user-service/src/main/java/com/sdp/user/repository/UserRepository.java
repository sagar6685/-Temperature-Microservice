package com.sdp.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sdp.user.model.User;

@Repository
public interface UserRepository  extends MongoRepository<User, Integer> {
    
	public List<User> findById(String userName);
}
