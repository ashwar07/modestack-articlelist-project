package com.example.articleproject.model;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	
	User findByAccessToken(String accesstoken);
	
	

	

}
