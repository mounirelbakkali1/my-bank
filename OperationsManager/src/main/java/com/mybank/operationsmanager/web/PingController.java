package com.mybank.operationsmanager.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ops")
public class PingController {


    @GetMapping("/ping")
    public String ping(){
        return  "ping";
    }
}
