package com.aipalbot.sell.taja.services;

import com.aipalbot.sell.taja.enums.APIMessages;
import com.aipalbot.taja.models.User;

public interface TajaUserService {

    APIMessages authenticateUser(String username, String password);
    APIMessages retrieveUser(String username);
    APIMessages updateUser(User user, String username);
    
}
