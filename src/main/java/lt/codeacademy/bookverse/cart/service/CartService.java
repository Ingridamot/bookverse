package lt.codeacademy.bookverse.cart.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.service.BookService;
import lt.codeacademy.bookverse.cart.dto.CartDto;
import org.springframework.stereotype.Service;
import lt.codeacademy.bookverse.cart.dto.CartItemDto;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartService {

    private final BookService bookService;

    public void addBookToCartByBookId(final UUID bookId, final CartDto cart) {
        this.getCartItem(bookId, cart)
                .ifPresentOrElse(
                        CartItemDto::incrementQuantity,
                        () -> addBookToCart(bookId, cart)
                );
    }

    private Optional<CartItemDto> getCartItem(UUID bookId, CartDto cart) {
        return cart.getCartItems().stream()
                .filter(cartItemDto -> cartItemDto.getBookDto().getBookId().equals(bookId))
                .findAny();
    }

    private void addBookToCart(final UUID bookId, final CartDto cart) {
        final BookDto bookDto = bookService.getBookByUUID(bookId);
        cart.add(bookDto);
    }
}

