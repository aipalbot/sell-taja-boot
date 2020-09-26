package com.aipalbot.sell.taja.services;


import com.aipalbot.taja.models.Item;

public interface TajaService {
    public Item retrieveItem(String itemId);
    public String saveItem(Item item);
}
