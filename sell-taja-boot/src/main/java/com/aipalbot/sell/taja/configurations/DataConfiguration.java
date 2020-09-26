package com.aipalbot.sell.taja.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;


public class DataConfiguration {

    @Value("${username}")
    private String userName;

    @Value("${server.port}")
    private int serverPortNo;

    public String getUserName(){
        return userName;
    }

    public int getServerPortNo(){
        return serverPortNo;
    }

}
