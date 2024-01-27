package lt.codeacademy.bookverse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {

    @GetMapping("/books/create")
    public String sayHelloToCustomer(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @PostMapping("/books/create")
    public String createABook(Book book) {

        System.out.println(book);
        return "hello";
    }
}
