package lt.codeacademy.bookverse.mappers;

import lt.codeacademy.bookverse.book.Book;
import lt.codeacademy.bookverse.book.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        return new BookDto(
                book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getAmount()
        );
    }


    public Book fromBookDto(BookDto bookDto) {
        return Book.builder()
                .bookId(bookDto.getBookId())
                .price(bookDto.getPrice())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .amount(bookDto.getAmount())
                .build();
    }
}
