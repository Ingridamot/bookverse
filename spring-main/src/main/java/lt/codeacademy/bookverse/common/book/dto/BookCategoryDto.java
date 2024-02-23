package lt.codeacademy.bookverse.common.book.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookCategoryDto {
    private final Long id;
    private final String name;
}
