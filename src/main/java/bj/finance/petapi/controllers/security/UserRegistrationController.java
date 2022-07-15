//package bj.finance.petapi.controllers.security;
//
//
//import bj.finance.petapi.dto.UserRegistrationDto;
//import bj.finance.petapi.model.Person;
//import bj.finance.petapi.model.security.User;
//import bj.finance.petapi.services.security.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.time.format.DateTimeFormatter;
//
////@Controller
////@RequestMapping({"/registration", "/registration/"})
//public class UserRegistrationController {
//
//    private final UserService userService;
//
//    public UserRegistrationController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @ModelAttribute("user")
//    public UserRegistrationDto userRegistrationDto(){
//        return new UserRegistrationDto();
//    }
//
//    @GetMapping()
//    public String showRegistrationForm(Model model){
//
//        //userService.save(registrationDto);
//        model.addAttribute("user", new UserRegistrationDto());
//
//        return "security/registrationForm";
//    }
//
//    @PostMapping()
//    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
//
//        userService.save(registrationDto);
//
//        return "redirect:/registration?success";
//    }
//}
