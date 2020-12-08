package ru.indivio.homecrm.services;

import ru.indivio.homecrm.dto.BookDto;

import java.util.List;


public interface BookService {
    BookDto findById(Long id);
    BookDto findByTitle(String title);
    List<BookDto> findAll();
    void save(BookDto book);
    void delete(Long id);
}
