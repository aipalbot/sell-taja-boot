package com.aipalbot.sell.taja.controllers;

/*
https://stackoverflow.com/questions/22398892/how-to-capture-multiple-parameters-using-requestparam-using-spring-mvc
https://stackoverflow.com/questions/3625672/java-exception-handling
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StackOverflowController {


    @GetMapping("/questions/{id}/{question}")
    public ResponseEntity<String> searchQuestion(@PathVariable(name="id") String id2, @PathVariable String question){

        String response = " Search from Stackoverflow for: " + question;
        ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        return responseEntity;
    }
}
