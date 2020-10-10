package com.aipalbot.sell.taja.impl;

import com.aipalbot.sell.taja.enums.APIMessages;
import com.aipalbot.sell.taja.services.TajaUserService;
import com.aipalbot.taja.models.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TajaUserServiceImpl implements TajaUserService {

    private final String USERNAME="root";
    private final String PASSWORD = "password";
    private static List<Integer> numbers = new ArrayList<>();
    
    static {
    	numbers.add(10);
    	numbers.add(5);
    	numbers.add(4);
    	numbers.add(2);    	
    }

    @Override
    public APIMessages authenticateUser(String username, String password) {

        //validate the username and password if exists
        if(USERNAME.equalsIgnoreCase(username) && PASSWORD.equals(password))
        {
            return  APIMessages.LOGIN_SUCCESSFUL;
        }

        return APIMessages.LOGIN_FAILURE;
    }

	@Override
	public APIMessages retrieveUser(String username) {
		// TODO check if the username provided is the same as our USERNAME constant then return message for 200, true else return false
		int size = numbers.size();
		if(numbers.contains(9)) {
			
		}
		
		return null;
	}

	@Override
	public APIMessages updateUser(User user, String username) {
		// TODO Auto-generated method stub
		return APIMessages.USER_UPDATED_SUCCESSFUL;
	}
}
