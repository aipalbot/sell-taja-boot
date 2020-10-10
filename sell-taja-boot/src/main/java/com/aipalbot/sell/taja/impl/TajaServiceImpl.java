package com.aipalbot.sell.taja.impl;

import com.aipalbot.sell.taja.services.TajaService;
import com.aipalbot.taja.models.Item;
import com.aipalbot.taja.utils.enums.TajaAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Service
public class TajaServiceImpl implements TajaService {
    static Map<String,Item> data = new HashMap<>();
    static ConcurrentMap<String,Item> dataConcurrent = new ConcurrentHashMap<>();

    static {

        Item item1= new Item();
        item1.setId("C100");
        item1.setName("Oranges");
        item1.setAction(TajaAction.Sell);


        Item item2= new Item();
        item2.setId("C101");
        item2.setName("Mangoes");
        item2.setAction(TajaAction.Sell);


        data.put(item1.getId(), item1);
        data.put(item2.getId(),item2);
        
     
        dataConcurrent.put(item1.getId(), item1);
        dataConcurrent.put(item2.getId(),item2);
    }

    TajaServiceImp2 tjs2;



    public TajaServiceImpl(TajaServiceImp2 tjs){
        this.tjs2 = tjs;
    }


    @Override
    public Item retrieveItem(String itemId) {
        tjs2.retrieveItem(itemId);

        return data.get(itemId);
    }

    @Override
    public String saveItem(Item item) {
        double price = Double.parseDouble(item.getPrice());
        int quantity = Integer.parseInt(item.getQuantity());
        double totalCost = price * quantity;
        item.setTotalAmount(String.valueOf(totalCost));

        data.put(item.getId(),item);

        return "Saved successfully!";
    }
}
