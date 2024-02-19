package lt.codeacademy.bookverse.book.mappers;

import java.util.HashSet;
import java.util.stream.Collectors;

import lt.codeacademy.bookverse.common.mapper.Mapper;
import lt.codeacademy.bookverse.book.pojo.Book;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.pojo.BookCategory;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<Book, BookDto> {

    public BookDto toDto(Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .categoryIds(book.getBookCategories().stream().map(BookCategory::getId).collect(Collectors.toList()))
                .amount(book.getAmount())
                .build();
    }


    public Book fromDto(BookDto bookDto) {
        return Book.builder()
                .bookId(bookDto.getBookId())
                .price(bookDto.getPrice())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .amount(bookDto.getAmount())
                .bookCategories(new HashSet<>())
                .build();
    }
}
