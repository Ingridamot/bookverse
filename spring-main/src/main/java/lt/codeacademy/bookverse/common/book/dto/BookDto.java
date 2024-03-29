package lt.codeacademy.bookverse.common.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BookDto {

    private UUID bookId;

    @NotBlank(message = "{bookdto.title.notblank}")
    private String title;

    @NotBlank(message = "{bookdto.author.notblank}")
    private String author;

    @Positive(message = "{bookdto.positive}")
    private BigDecimal price;

    @Positive(message = "{bookdto.positive}")
    @NotNull
    private int amount;

    @NotNull
    private List<Long> categoryIds;
}
