package com.aipalbot.sell.taja.services;

import com.aipalbot.sell.taja.enums.APIMessages;

public interface TajaUserService {

    APIMessages authenticateUser(String username, String password);
    APIMessages retrieveUser(String username);
    
}
