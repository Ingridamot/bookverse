package lt.codeacademy.bookverse.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private UUID bookId;
    private String title;
    private String author;
    private double price;
    private int amount;
}
