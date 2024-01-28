package lt.codeacademy.bookverse.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public class BookDto {
    private UUID bookId;
    private String title;
    private String author;
    private double price;
    private int amount;
}
