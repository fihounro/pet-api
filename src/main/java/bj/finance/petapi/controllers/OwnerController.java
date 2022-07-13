package bj.finance.petapi.controllers;

import bj.finance.petapi.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listAllOwners(Model model){

        model.addAttribute("owners",ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){

        return "notImplemented";
    }
}
