package ru.indivio.homecrm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.indivio.homecrm.dto.BookDto;
import ru.indivio.homecrm.entities.Book;
import ru.indivio.homecrm.mapers.BookMapper;
import ru.indivio.homecrm.repositories.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper mapper = BookMapper.MAPPER;
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAll() {
        return BookMapper.MAPPER.toBookDtoList(bookRepository.findAll());
    }

    @Override
    public void save(BookDto bookDto) {
        bookRepository.save(BookMapper.MAPPER.toBook(bookDto));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        return BookMapper.MAPPER.fromBook(book);
    }

    @Override
    public BookDto findByTitle(String title) {
        Book book = bookRepository.findByTitle(title).orElse(new Book());
        return BookMapper.MAPPER.fromBook(book);
    }

    public void addBook(BookDto bookDto) {
        Book book = BookMapper.MAPPER.toBook(bookDto);
        bookRepository.save(book);

    }
}
