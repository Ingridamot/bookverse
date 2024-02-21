package lt.codeacademy.bookverse.common.cart.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lt.codeacademy.bookverse.common.book.dto.BookDto;

@Getter
public class CartDto {

    private final List<CartItemDto> cartItems = new ArrayList<>();

    public void add(final BookDto bookDto) {
        cartItems.add(CartItemDto.builder()
                .bookDto(bookDto)
                .quantity(1)
                .build());
    }

    public BigDecimal getCartTotalPrice() {
        return cartItems.stream()
                .map(CartItemDto::getTotalItemPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getCartTotalQuantity() {
        return cartItems.stream()
                .map(CartItemDto::getQuantity)
                .reduce(0, Integer::sum);
    }
}

