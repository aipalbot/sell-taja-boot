package com.aipalbot.sell.taja.impl;

import com.aipalbot.sell.taja.enums.APIMessages;
import com.aipalbot.sell.taja.services.TajaUserService;
import org.springframework.stereotype.Service;

@Service
public class TajaUserServiceImpl implements TajaUserService {

    private final String USERNAME="root";
    private final String PASSWORD = "password";

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
		
		return null;
	}
}
