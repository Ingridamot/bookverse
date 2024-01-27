package lt.codeacademy.bookverse.book;

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


    @GetMapping("/books/create")
    public String sayHelloToCustomer(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/books/create")
    public String createABook(Book book) {

        bookService.saveBook(book);
        System.out.println("currently in the database");
        bookService.getAllBooks().forEach(System.out::println);
        return "hello";
    }
}

