package com.example.articleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.articleproject.model.User;
import com.example.articleproject.model.UserRepository;
import com.example.articleproject.vo.UserVO;

@Service
public class UserService{


    @Autowired
    UserRepository userRepository;
    public String createUser(UserVO userVO) {
        String registrationStatus=convertUserVOtoModel(userVO);
        return registrationStatus;
    }
        

    private String convertUserVOtoModel(UserVO userVO) {
        User user = new User();
        if(null != userVO.getUsername() && null != userVO.getPassword() && null != userVO.getEmail() )
        {
        	 user.setUsername(userVO.getUsername());
             user.setPassword(userVO.getPassword());
             user.setEmail(userVO.getEmail());
             user.setAddress(userVO.getAddress());
             userRepository.save(user);
             
             return "New user created";
        }
        else
        {
        	return "Please Fill all informaation  to complete Registration";
        }
       
    }

    public String validateUser(UserVO userVO) {
	    	
    	TokenService access_token = new TokenService();
    	CurrentDateService crdtSvc = new CurrentDateService();

    	String dateString = crdtSvc.currentDateString();
    	String accessToken = access_token.generateToken();
    	
    	User existingUser = userRepository.findByUsername(userVO.getUsername());
    	if(null == existingUser||existingUser.equals(""))
    	{
    		return accessToken="USER NOT REGISTRED";
    	}
    	
    	if(null != userVO.getPassword() && existingUser.getPassword().equals(userVO.getPassword())) {
        	existingUser.setAccesstoken(accessToken);
        	existingUser.setDate(dateString);
        	userRepository.save(existingUser);
    	}else {
    		accessToken="FAILED";    		
    	}
    	
        return accessToken;
    }
}
