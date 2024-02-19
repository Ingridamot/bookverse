package lt.codeacademy.bookverse.book.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.bookverse.HttpEndpoints;
import lt.codeacademy.bookverse.helper.MessageService;
import lt.codeacademy.bookverse.book.dto.BookCategoryDto;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.service.BookCategoryService;
import lt.codeacademy.bookverse.book.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static lt.codeacademy.bookverse.HttpEndpoints.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookCategoryService bookCategoryService;
    private final MessageService messageService;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndpoints.BOOKS_CREATE)
    public String getFormForCreate(Model model, String message) {
        Set<BookCategoryDto> categories = bookCategoryService.getCategories();

        model.addAttribute("categoriesDto", categories);
        model.addAttribute("bookDto", BookDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));

        return "book/book";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(BOOKS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID bookId) {
        log.info("Got request for GET /books/{}/update", bookId);
        model.addAttribute("bookDto", bookService.getBookByUUID(bookId));

        return "book/book";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(BOOKS_CREATE)
    public String createABook(Model model, @Valid BookDto book, BindingResult errors) {
        if (errors.hasErrors()) {
            return "book/book";
        }

        bookService.saveBook(book);

        return "redirect:/books/create?message=book.create.message.success";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(BOOKS_UPDATE)
    public String updateBook(Model model, Pageable pageable, BookDto bookDto, @PathVariable UUID bookId) {
        bookService.updateBook(bookDto);

        return getBooks(model, pageable);
    }

    @GetMapping("/books/list")
    public String getBooks(Model model,
                           @PageableDefault(size = 5, sort = {"price"}, direction = Sort.Direction.ASC) Pageable pageable) {
        final Page<BookDto> allBooks = bookService.getAllBooksPage(pageable);
        model.addAttribute("bookList", allBooks);
        return "book/books";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(HttpEndpoints.BOOKS_DELETE)
    public String deleteBook(Model model, Pageable pageable, @PathVariable UUID bookId) {
        bookService.deleteBookByUUID(bookId);

        return getBooks(model, pageable);
    }
}

