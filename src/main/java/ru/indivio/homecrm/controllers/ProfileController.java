package ru.indivio.homecrm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.indivio.homecrm.entities.User;
import ru.indivio.homecrm.services.UsrService;

import java.security.Principal;

@Controller
public class ProfileController {
    private UsrService usrService;

    @Autowired
    public void setUserServiceImpl(UsrService usrService) {
        this.usrService = usrService;
    }

    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        User user = usrService.findByName(principal.getName());
        model.addAttribute("profile", user);
        return "profile";
    }
}
