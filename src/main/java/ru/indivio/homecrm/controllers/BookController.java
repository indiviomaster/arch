package ru.indivio.homecrm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.indivio.homecrm.dto.BookDto;
import ru.indivio.homecrm.entities.Book;
import ru.indivio.homecrm.entities.Client;
import ru.indivio.homecrm.entities.Deliveries;
import ru.indivio.homecrm.services.BookService;
import ru.indivio.homecrm.services.ClientService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private final Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping("")
    public String showBooks(Model model) {
        List<BookDto> bookDto = (List<BookDto>)bookService.findAll();
        model.addAttribute("books", bookDto);
        return "books-page";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable(name = "id") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }

}
