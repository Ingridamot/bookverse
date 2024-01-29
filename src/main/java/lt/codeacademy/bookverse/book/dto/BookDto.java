package lt.codeacademy.bookverse.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class BookDto {
    private UUID bookId;
    @NotBlank(message = "{bookdto.title.notblank}")
    private String title;
    @NotBlank(message = "{bookdto.author.notblank}")
    private String author;
    @Positive(message = "{bookdto.positive}")
    private double price;
    @Positive(message = "{productdto.positive}")
    @NotNull
    private int amount;
}
