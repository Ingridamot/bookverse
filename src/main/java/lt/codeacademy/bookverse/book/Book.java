package lt.codeacademy.bookverse.book;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String title;
    private String author;
    private double price;
    private int amount;
}
