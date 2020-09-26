package com.aipalbot.sell.taja.controllers;


import com.aipalbot.taja.models.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/expenses")
public class ExpensesController {

    @GetMapping
    public String getExpense(){
        Item item = new Item();
        item.setExpense("Oranges paid");

        return item.getExpense();
    }

}
