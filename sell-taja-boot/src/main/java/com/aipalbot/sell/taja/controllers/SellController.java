package com.aipalbot.sell.taja.controllers;

import com.aipalbot.sell.taja.impl.TajaServiceImp2;
import com.aipalbot.sell.taja.impl.TajaServiceImpl;
import com.aipalbot.sell.taja.services.TajaService;
import com.aipalbot.taja.models.Item;
import com.aipalbot.taja.utils.enums.TajaAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/sell")
public class SellController {

    @Autowired
    TajaService tajaService;
//
//    @Autowired
//    TajaServiceImp2 tajaServiceImp2;

    @Value("${app.username}")
    private String userName;
    
    @Value("${server.port}")
    private String serverPortNo;

    
    @GetMapping
    public String getItemName(){
        Item item = new Item();
        item.setName("Oranges");

        return item.getName();
    }

    @GetMapping("/username")
    public String getName() {
    	return userName;
    }
    
    
    
    @GetMapping("/port")
    public String getPort() {
    	return serverPortNo;
    }
    
    
    @GetMapping("/quantity")
    public String getItem(){
        Item item = new Item();
        item.setQuantity("34");

        return item.getQuantity();
    }

    @GetMapping("/action")
    public String getAction(){
        Item item = new Item();
        item.setAction(TajaAction.Sell);

        return item.getAction().toString();
    }

    @GetMapping("/item")
    public ResponseEntity<Item> getItemById(@RequestParam String itemId){

        ResponseEntity<Item> responseEntity;
        try {
            Item item = tajaService.retrieveItem(itemId);
            responseEntity = new ResponseEntity<>(item, HttpStatus.OK);

        }catch(Exception e) {
            responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
       //return  new ResponseEntity<>(item, HttpStatus.OK);
    }


    @GetMapping("/item/{itemId}")
    public ResponseEntity<Item> getItemByIdPath(@PathVariable String itemId){

      //  tajaServiceImp2.retrieveItem(itemId);

        ResponseEntity<Item> responseEntity;
        try {
            Item item = tajaService.retrieveItem(itemId);
            responseEntity = new ResponseEntity<>(item, HttpStatus.OK);

        }catch(Exception e) {
            responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
        //return  new ResponseEntity<>(item, HttpStatus.OK);
    }



    @PostMapping("/item")
    public ResponseEntity<String> save( @RequestBody Item item){

     String response =    tajaService.saveItem(item);

     return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
