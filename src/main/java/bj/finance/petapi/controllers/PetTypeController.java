package bj.finance.petapi.controllers;

import bj.finance.petapi.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetTypeController {

    private final PetTypeService petTypeService;

    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @RequestMapping({"petTypes","petTypes/index","petTypes/index.html"})
    public String listAllPetType(Model model){

        model.addAttribute("petTypes", petTypeService.findAll());

        return "petTypes/index";
    }
}
