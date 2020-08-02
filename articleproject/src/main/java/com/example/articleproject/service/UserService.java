package com.example.articleproject.service;

import com.example.articleproject.model.User;
import com.example.articleproject.model.UserRepository;
import com.example.articleproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //yet to do
        return userVO.getUsername() + userVO.getPassword();
    }
}
