package com.example.articleproject.service;

import java.util.Random;

public class TokenService {
	
    public String generateToken() {
    	
    	//Generate the access token
    	
        int leftLimit = 65; // letter 'A'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 20;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String access_token = buffer.toString();

        //yet to do
        return access_token;
    }


}
