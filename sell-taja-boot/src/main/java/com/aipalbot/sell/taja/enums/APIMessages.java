package com.aipalbot.sell.taja.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;


@Getter
public enum APIMessages {
	
	LOGIN_SUCCESSFUL("Successful Operation",HttpStatus.OK),
	LOGIN_FAILURE("Invalid username/password supplied",HttpStatus.BAD_REQUEST), //comment put comma and add more messages
	USER_UPDATED_SUCCESSFUL("User is updated successfully", HttpStatus.OK);
	
	
	
	private String message;
    private HttpStatus code;
    
    APIMessages(String message, HttpStatus code){
        this.message=message;
        this.code = code;
    }
    

}
