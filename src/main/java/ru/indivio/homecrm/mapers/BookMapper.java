package ru.indivio.homecrm.mapers;

import ru.indivio.homecrm.dto.BookDto;
import ru.indivio.homecrm.entities.Book;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper MAPPER = Mappers.getMapper(BookMapper.class);

    Book toBook(BookDto dto);

    @InheritInverseConfiguration
    BookDto fromBook(Book book);

    List<Book> toBookList(List<BookDto> bookDtos);

    List<BookDto> toBookDtoList(List<Book> books);

}
