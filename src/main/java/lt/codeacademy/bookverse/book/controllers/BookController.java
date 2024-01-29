package lt.codeacademy.bookverse.book.controllers;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lt.codeacademy.bookverse.HttpEndpoints;
import lt.codeacademy.bookverse.helper.MessageService;
import lt.codeacademy.bookverse.book.Book;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.exception.BookNotFoundException;
import lt.codeacademy.bookverse.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final MessageService messageService;


    @GetMapping(HttpEndpoints.BOOKS_CREATE)
    public String getFormForCreate(Model model, String message) {
        log.atInfo().log("-==== get book on create ====-");
        model.addAttribute("bookDto", BookDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));

        return "book/book";
    }

    @GetMapping(HttpEndpoints.BOOKS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID bookId) {
        log.atInfo().log("-==== get book on update ====-");
        model.addAttribute("bookDto", bookService.getBookByUUID(bookId));
        return "book/book";
    }

    @PostMapping(HttpEndpoints.BOOKS_CREATE)
    public String createABook(Model model, @Valid BookDto book, BindingResult errors) {
        if (errors.hasErrors()) {
            return "book/book";
        }
            bookService.saveBook(book);

        return "redirect:/books/create?message=book.create.message.success";
    }

    @PostMapping(HttpEndpoints.BOOKS_UPDATE)
    public String updateBook(Model model, Pageable pageable, Book book, @PathVariable UUID bookId) {
        bookService.updateBook(book);

        return getBooks(model, pageable);
    }

    @GetMapping(HttpEndpoints.BOOKS)
    public String getBooks(Model model,
                           @PageableDefault(size = 5, sort = {"price"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<BookDto> allBooks = bookService.getAllBooksPage(pageable);
        model.addAttribute("bookList", allBooks);
        return "book/books";
    }

    @GetMapping(HttpEndpoints.BOOKS_DELETE)
    public String deleteBook(Model model, Pageable pageable, @PathVariable UUID bookId) {
        bookService.deleteBookByUUID(bookId);

        return getBooks(model, pageable);
    }
    @ExceptionHandler
    public String bookNotFound(BookNotFoundException e, Model model) {
        return "product/error/productNotFound";
    }
}

