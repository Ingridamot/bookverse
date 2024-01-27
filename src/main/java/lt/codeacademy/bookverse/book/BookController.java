package lt.codeacademy.bookverse.book;

import java.util.List;
import java.util.UUID;

import lombok.extern.log4j.Log4j2;
import lt.codeacademy.bookverse.HttpEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Log4j2
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(HttpEndpoints.BOOKS_CREATE)
    public String getFormForCreate(Model model) {
        log.atInfo().log("-==== get book on create ====-");
        model.addAttribute("book", Book.builder().build());
        return "book/book";
    }

    @GetMapping(HttpEndpoints.BOOKS_UPDATE)
    public String getFormForUpdate(Model model, @PathVariable UUID bookId) {
        log.atInfo().log("-==== get book on update ====-");
        model.addAttribute("book", bookService.getBookByUUID(bookId));
        return "book/book";
    }

    @PostMapping(HttpEndpoints.BOOKS_CREATE)
    public String createABook(Model model, Book book) {
        bookService.saveBook(book);
        model.addAttribute("message", "Book added successfully!");

        return "book/book";
    }

    @PostMapping(HttpEndpoints.BOOKS_UPDATE)
    public String updateBook(Model model, Book book, @PathVariable UUID bookId) {
        bookService.updateBook(book);

        return getBooks(model);
    }

    @GetMapping(HttpEndpoints.BOOKS)
    public String getBooks(Model model) {
        final List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("bookList", allBooks);
        return "book/books";
    }

    @GetMapping(HttpEndpoints.BOOKS_DELETE)
    public String deleteBook(Model model, @PathVariable UUID bookId) {
        bookService.deleteBookByUUID(bookId);

        return getBooks(model);
    }

}

