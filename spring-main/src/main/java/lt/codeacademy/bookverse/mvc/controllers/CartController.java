package lt.codeacademy.bookverse.mvc.controllers;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.common.cart.dto.CartDto;
import lt.codeacademy.bookverse.common.cart.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cartSession")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @ModelAttribute("cartSession")
    public CartDto createDefaultCartSession() {
        return new CartDto();
    }

    @GetMapping
    public String openCart() {
        return "/cart/cart";
    }

    @PostMapping("/{bookId}")
    public String addToCart(@PathVariable UUID bookId,
                            @ModelAttribute("cartSession") CartDto cart) {
        cartService.addBookToCartByBookId(bookId, cart);

        return "redirect:/books/list";
    }

    @PostMapping
    public String order(SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        //TODO: save into DB or do other things with cart data

        sessionStatus.setComplete();

        redirectAttributes.addFlashAttribute("successMessageFlashAttr", "Order created successfully!");

        return "redirect:/books/list";
    }

}
