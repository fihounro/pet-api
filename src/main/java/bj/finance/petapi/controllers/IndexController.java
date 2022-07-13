package bj.finance.petapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    String index(){
        return "index";
    }

    @RequestMapping({"/login", "/login/", "/login.html", "/login.html/"})
    String login(){
        return "security/login";
    }

    @RequestMapping("/oups")
    String oups(){
        return "notImplemented";
    }
}
