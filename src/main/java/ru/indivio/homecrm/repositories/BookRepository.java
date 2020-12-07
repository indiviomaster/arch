package ru.indivio.homecrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.indivio.homecrm.dto.BookDto;
import ru.indivio.homecrm.entities.Book;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);
}
