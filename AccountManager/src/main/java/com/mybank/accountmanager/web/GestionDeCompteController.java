package com.mybank.accountmanager.web;

import com.mybank.accountmanager.services.IGestionCompteService;
import com.mybank.persistencemanager.entities.Compte;
import com.mybank.persistencemanager.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class GestionDeCompteController {

    @Autowired
    IGestionCompteService iBankService;

    @RequestMapping("/operations")
    public String index() {
        return "comptes";
    }

    @RequestMapping("/consulterUnCompte")
    public String consulterUnCompte(Model model, String codeDeCompte, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "5") int size, @RequestParam(value = "opMsg", defaultValue = "") String opMsg) {
        try {
            Compte compte = iBankService.consulterUnCompte(codeDeCompte);
            Page<Operation> operations = iBankService.listOfOperations(codeDeCompte, page, size);
            int[] pages = new int[operations.getTotalPages()];
            model.addAttribute("compte", compte);
            model.addAttribute("operations", operations);
            model.addAttribute("pages", pages);
            if (!opMsg.isEmpty()) model.addAttribute("opMsg", opMsg);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "comptes";
    }

    @PostMapping("/saveOperation")
    public String saveOperation(Model model, @RequestParam("type") String type, @RequestParam("codeDeCompte1") String codeDeCompte1, @RequestParam(value = "codeDeCompte2", defaultValue = "") String codeDeCompte2, @RequestParam("montant") BigDecimal montant) {
        String message;
        try {
            if (type.equals("V")) {
                iBankService.verser(codeDeCompte1, montant);
            } else if (type.equals("R")) {
                iBankService.retirer(codeDeCompte1, montant);
            } else if (type.equals("T")) {
                iBankService.virement(codeDeCompte1, codeDeCompte2, montant);
            }
            message = "SUCCESS: operation effectue :)";
        } catch (Exception e) {
            message = "FAILED: operation_failed :(  " + e.getMessage();
        }
        return "redirect:/consulterUnCompte?codeDeCompte=" + codeDeCompte1 + "&opMsg=" + message;
    }


}
