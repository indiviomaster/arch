package ru.indivio.homecrm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.indivio.homecrm.entities.Client;
import ru.indivio.homecrm.entities.Deliveries;
import ru.indivio.homecrm.services.ClientService;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);


    @GetMapping("")
    public String showClients(Model model) {
        List<Client> client = (List<Client>)clientService.findAll();
        model.addAttribute("clients", client);
        return "clients-page";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable(name = "id") Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }

    @GetMapping("/clone/{id}")
    public String cloneById(Model model,@PathVariable(name = "id") Long id) {
        clientService.cloneById(id);
        return "redirect:/clients";
    }

    @GetMapping("/deliver/{cost}")
    public String deliver(Model model,@PathVariable(name = "cost") Integer cost) {
        Deliveries.deliver(cost);
        return "redirect:/clients";
    }
}
