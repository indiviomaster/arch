package ru.indivio.homecrm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.indivio.homecrm.entities.Call;
import ru.indivio.homecrm.entities.Client;
import ru.indivio.homecrm.entities.Deliveries;
import ru.indivio.homecrm.services.CallService;
import ru.indivio.homecrm.services.CallServiceImpl;
import ru.indivio.homecrm.services.ClientService;

import java.util.List;

@Controller
@RequestMapping("/calls")
public class CallController {
    private CallServiceImpl callService;

    @Autowired
    public void setCallService(CallServiceImpl callService) {
        this.callService = callService;
    }

    private final Logger logger = LoggerFactory.getLogger(CallController.class);


    @GetMapping("")
    public String showAllCalls(Model model) {
        List<Call> calls = (List<Call>)callService.findAll();
        model.addAttribute("calls", calls);
        return "calls-page";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable(name = "id") Long id) {
        callService.delete(id);
        return "redirect:/calls";
    }

    /*@GetMapping("/new")
    public String newCall(Model model) {
        Call call = new Call();
        callService.save(call);
        return "redirect:/calls";
    }*/
}
