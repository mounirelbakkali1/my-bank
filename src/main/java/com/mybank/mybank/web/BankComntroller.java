package com.mybank.mybank.web;

import com.mybank.mybank.entities.Compte;
import com.mybank.mybank.entities.Operation;
import com.mybank.mybank.services.IBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankComntroller {

    @Autowired
    IBankServiceImpl iBankService;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

    @RequestMapping("/consulterUnCompte")
    public String consulterUnCompte(Model model , String codeDeCompte){
        try{
            Compte compte = iBankService.consulterUnCompte(codeDeCompte);
            Page<Operation> operations = iBankService.listOfOperations(codeDeCompte,0,4);
            model.addAttribute("compte",compte);
            model.addAttribute("operations",operations);
        }catch (Exception e){
            model.addAttribute("errorMessage",getErrorMessage(e));
        }
         return "comptes";
    }

    private String getErrorMessage(Exception e) {
        return e.getMessage();
    }
}
