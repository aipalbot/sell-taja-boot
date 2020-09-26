package com.aipalbot.sell.taja.controllers;


/*
https://www.google.com/search?
q=Jovita+Id%C3%A1r&
oi=ddle&
ct=144867442&
hl=en&
kgmid=%2Fm%2F07k6qh_&
source=doodle-ntp&
ved=0ahUKEwjHqZ2vtPvrAhXuhXIEHZwMDMgQPQgB

 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GoogleSearchController {

    @GetMapping("/search")
    public ResponseEntity<String> searchData(@RequestParam String q,
                                            @RequestParam String oi,
                                            @RequestParam String ct,
                                            @RequestParam String hl,
                                            @RequestParam String kgmid,
                                            @RequestParam String source,
                                            @RequestParam String ved) {

        return new ResponseEntity<>("Search result from Google", HttpStatus.OK);
    }


}
