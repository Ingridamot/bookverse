package lt.codeacademy.bookverse.cart.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.bookverse.cart.calculator.CartItemCalculator;
import lt.codeacademy.bookverse.book.dto.BookDto;

@Builder
@Getter
public class CartItemDto {

    private final BookDto bookDto;
    private int quantity;

    public void incrementQuantity() {
        quantity++;
    }
    public BigDecimal getTotalItemPrice() {
        return CartItemCalculator.calculateTotal(this);
    }
}

