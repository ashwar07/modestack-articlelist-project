package com.example.articleproject.service;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.articleproject.model.User;
import com.example.articleproject.model.UserRepository;
import com.example.articleproject.vo.UserVO;

@Service
public class UserService{


    @Autowired
    UserRepository userRepository;

    public void createUser(UserVO userVO) {
        convertUserVOtoModel(userVO);
    }
        

    private void convertUserVOtoModel(UserVO userVO) {
        User user = new User();
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        user.setEmail(userVO.getEmail());
        user.setAddress(userVO.getAddress());
        userRepository.save(user);
    }

    public String validateUser(UserVO userVO) {
	    	
    	TokenService access_token = new TokenService();
    	CurrentDateService crdtSvc = new CurrentDateService();

    	String dateString = crdtSvc.currentDateString();
    	String accessToken = access_token.generateToken();
    	
    	User existingUser = userRepository.findByUsername(userVO.getUsername());
    	if(existingUser.getPassword().equals(userVO.getPassword())) {
        	existingUser.setAccesstoken(accessToken);
        	existingUser.setDateString(dateString);
        	userRepository.save(existingUser);
    	}else {
    		accessToken="FAILED";    		
    	}
    	
        return accessToken;
    }
}
