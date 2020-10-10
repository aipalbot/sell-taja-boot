package com.aipalbot.sell.taja.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aipalbot.sell.taja.impl.GenericSellServiceImpl;
import com.aipalbot.sell.taja.models.Account;
import com.aipalbot.sell.taja.models.CheckingAccount;
import com.aipalbot.sell.taja.models.SavingAccount;
import com.aipalbot.sell.taja.services.GenericSellService;
import com.aipalbot.sell.taja.services.TajaService;
import com.aipalbot.taja.models.Item;
import com.aipalbot.taja.models.LambdaResponse;
import com.aipalbot.taja.utils.enums.TajaAction;

@RestController
@RequestMapping(path = "/v1/sell")
public class SellController {

    @Autowired
    TajaService tajaService;
    
    GenericSellService<LambdaResponse> genericService = new GenericSellServiceImpl<>();
    
    List<String> list = new ArrayList<>();
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

    
    @PostMapping("/generic/item")
    public ResponseEntity<?> saveItem(@RequestBody Item item){
    	
    	LambdaResponse  response = genericService.getData(item);
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/generic/account")
    public ResponseEntity<?> saveItem(@RequestBody Account[] accounts){
    	
    	List<Account> accts= new ArrayList<>();
    	for(Account acct : accounts) {
    		if(acct.getAcctType().equalsIgnoreCase("Checking")) {
    			CheckingAccount chk= new CheckingAccount();
    			chk.setAcctType(acct.getAcctType());
    			chk.setId(acct.getId());
    			chk.setName(acct.getAcctType());
    			accts.add(chk);
    		}else if(acct.getAcctType().equalsIgnoreCase("Saving")) {
    			SavingAccount sav= new SavingAccount();
    			sav.setAcctType(acct.getAcctType());
       			sav.setId(acct.getId());
       			sav.setName(acct.getAcctType());
    			accts.add(sav);
    		}
    	}
    	
    	Object[]  response =genericService.calculate(accts.toArray());
    	
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
