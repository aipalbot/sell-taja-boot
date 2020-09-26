package com.aipalbot.sell.taja.controllers;


import com.aipalbot.sell.taja.services.TajaService;
import com.aipalbot.taja.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/new-purchase")
public class NewPurchasesController{



    @GetMapping
    public String getPurchasedItem(){
        Item item = new Item();
        item.setName("Oranges purchased");


        return item.getName();
    }

}
