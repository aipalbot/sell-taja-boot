package com.aipalbot.sell.taja.enums;

import lombok.Getter;


@Getter
public enum APIMessages {
	
	LOGIN_SUCCESSFUL("Successful Operation",200),
	LOGIN_FAILURE("Invalid username/password supplied",400); //comment put comma and add more messages
	
	
	
	private String message;
    private int code;
    
    APIMessages(String message, int code){
        this.message=message;
        this.code = code;
    }
    

}
