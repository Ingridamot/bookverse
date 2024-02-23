package lt.codeacademy.bookverse.common.cart.calculator;

import java.math.BigDecimal;

import lt.codeacademy.bookverse.common.cart.dto.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemCalculator {

    public static BigDecimal calculateTotal(final CartItemDto cartItemDto) {
        return cartItemDto.getBookDto().getPrice().multiply(BigDecimal.valueOf(cartItemDto.getQuantity()));
    }
}


