package com.jinternals.vault.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class VaultController {

    @Value("${test}")
    private String test;

    @RequestMapping(value = "/test")
    public ResponseEntity<String> getTestConfig(){
        return new ResponseEntity<String>(test, OK);
    }

}
