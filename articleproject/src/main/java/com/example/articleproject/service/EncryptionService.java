package com.example.articleproject.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
	
    private String encryptedValue = null;
    
	public String encrypt(String originalString) {
        try {
        	
        	encryptedValue = Base64.getEncoder().encodeToString(originalString.getBytes("utf-8" ));
        	
        } catch (Exception e) {
            System.out.println("Error while encrypting... " + e.getStackTrace());
        }
        
        return encryptedValue;
    }
 
}