package com.mybank.mybank.web;

import com.mybank.mybank.services.IBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankComntroller {

    @Autowired
    IBankServiceImpl iBankService;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }
}
