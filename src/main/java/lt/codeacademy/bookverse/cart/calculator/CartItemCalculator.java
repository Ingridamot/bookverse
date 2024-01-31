package lt.codeacademy.bookverse.cart.calculator;

import java.math.BigDecimal;

import lt.codeacademy.bookverse.cart.dto.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemCalculator {

    public static BigDecimal calculateTotal(final CartItemDto cartItemDto) {
        return cartItemDto.getBookDto().getPrice().multiply(BigDecimal.valueOf(cartItemDto.getQuantity()));
    }
}

