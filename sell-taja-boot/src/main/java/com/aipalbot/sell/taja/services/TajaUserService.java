package com.aipalbot.sell.taja.services;

public interface TajaUserService {

    boolean authenticateUser(String username, String password);
    String retrieveUser(String username);
    
}
