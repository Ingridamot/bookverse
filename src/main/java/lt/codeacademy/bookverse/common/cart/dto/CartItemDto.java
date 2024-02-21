package lt.codeacademy.bookverse.common.cart.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lt.codeacademy.bookverse.common.cart.calculator.CartItemCalculator;
import lt.codeacademy.bookverse.common.book.dto.BookDto;

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

