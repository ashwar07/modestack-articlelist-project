package com.example.articleproject.rest;


import com.example.articleproject.service.UserService;
import com.example.articleproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping(value = "register", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> register(@RequestBody UserVO userVO) throws Exception {
        userService.createUser(userVO);
        ResponseEntity<String> resp = new ResponseEntity<>("New user created", HttpStatus.CREATED);
        return resp;
    }

    @PostMapping(value = "login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserVO UserVO) throws Exception {
        String accesstoken = userService.validateUser(UserVO);
        Map<String, String> response = new HashMap<>();
        response.put("acessToken",accesstoken);
        response.put("message", "success");
        ResponseEntity<Map<String,String>> resp = new ResponseEntity<>(response, HttpStatus.OK);
        return resp;
    }


}
