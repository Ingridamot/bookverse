package lt.codeacademy.bookverse;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String title;
    private double price;
    private int amount;
}
