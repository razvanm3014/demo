package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHello")
public class TestController {

    @GetMapping
    public String sayHello()
    {
        return "Hellllo!";
    }




}
