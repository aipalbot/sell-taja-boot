package com.aipalbot.sell.taja.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aipalbot.sell.taja.enums.APIMessages;
import com.aipalbot.sell.taja.services.TajaUserService;
import com.aipalbot.taja.models.User;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    TajaUserService tajaUserService;

    @RequestMapping(method = RequestMethod.POST,value ="/user")
    public ResponseEntity<String> createUser(@RequestBody User user){

        User user1 = user;

        return null;
    }

    @PostMapping(value = "/user/createWithArray")
    public ResponseEntity<String>  createUsers(@RequestBody List<User> users){

        List<User> users1 = users;

        return null;

    }

    @GetMapping(value="/user/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password){
    	
        //String namePass="Successfully logged in. --> "+ username+" "+password;
    	APIMessages response = tajaUserService.authenticateUser(username, password);

        return new ResponseEntity<>( response.getMessage(),response.getCode() );
       
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<String> getUserByName(@PathVariable String username){
    	
    	//TODO: check if user is retrieved and reply appropriate response else reply all types of responses.
    	
    	return new ResponseEntity<>("test", HttpStatus.NOT_IMPLEMENTED);
    }
    
    
    @PutMapping("/user/{username}")
    public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody User user){
    	
    	APIMessages response = tajaUserService.updateUser(user, username);
    	
    	return new ResponseEntity<>(response.getMessage(), response.getCode());
    }
    
    
    @GetMapping("/user")
    public ResponseEntity<String> getUser(){
    	
    	APIMessages response = tajaUserService.retrieveUser(null);
    	
    	return new ResponseEntity<>(response.getMessage(), response.getCode());
    }
}
    
    
    
    

