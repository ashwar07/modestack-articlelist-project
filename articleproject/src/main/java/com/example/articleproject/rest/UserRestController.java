package com.example.articleproject.rest;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.articleproject.service.EncryptionService;
import com.example.articleproject.service.UserService;
import com.example.articleproject.vo.UserVO;

@RestController
@RequestMapping("/")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    EncryptionService securityService;

    @PostMapping(value = "register", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> register(@RequestBody UserVO userVO) throws Exception {
        String encryptPassword = securityService.encrypt(userVO.getPassword());
    	userVO.setPassword(encryptPassword);
        userService.createUser(userVO);
        ResponseEntity<String> resp = new ResponseEntity<>("New user created", HttpStatus.CREATED);
        return resp;
    }

    @PostMapping(value = "login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserVO userVO) throws Exception {
        String encryptPassword = securityService.encrypt(userVO.getPassword());        
    	userVO.setPassword(encryptPassword);
        String accesstoken = userService.validateUser(userVO);
        Map<String, String> response = new HashMap<>();
        response.put("acessToken",accesstoken);
        response.put("message", "success");
        ResponseEntity<Map<String,String>> resp = new ResponseEntity<>(response, HttpStatus.OK);
        return resp;
    }


}
