package lt.codeacademy.bookverse.book.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BooksRestController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooksPage(Pageable.ofSize(100))
                .stream().toList();
    }


    @PostMapping("/books")
    public ResponseEntity<BookDto> createABook(@RequestBody @Valid BookDto bookDto) {
        var savedBook = bookService.save(bookDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(savedBook);
    }
}
