package lt.codeacademy.bookverse.cart;

import jakarta.servlet.http.HttpServletRequest;
import lt.codeacademy.bookverse.book.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
public class CartController {

    @ModelAttribute("cartSession")
    public List<BookDto> createDefaultCartSession() {
        return List.of(BookDto.builder()
                .title("Testas")
                .build());
    }

    @GetMapping
    public String openCart() {
        return "/cart/cart";
    }

}
