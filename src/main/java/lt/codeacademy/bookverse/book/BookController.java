package lt.codeacademy.bookverse.book;

import java.util.List;

import lt.codeacademy.bookverse.HttpEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(HttpEndpoints.BOOKS_CREATE)
    public String sayHelloToCustomer(Model model) {
        model.addAttribute("book", new Book());
        return "book/book";
    }

    @PostMapping(HttpEndpoints.BOOKS_CREATE)
    public String createABook(Book book) {

        bookService.saveBook(book);
        System.out.println("currently in the database");
        bookService.getAllBooks().forEach(System.out::println);
        return "welcome/welcome"; //tai nera URL Path
    }

    @GetMapping(HttpEndpoints.BOOKS)
    public String getBooks(Model model) {
        final List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("bookList", allBooks);
        return "book/books";
    }
}

