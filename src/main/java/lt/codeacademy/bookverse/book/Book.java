package lt.codeacademy.bookverse.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class Book {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID bookId;
    private String title;
    private String author;
    private double price;
    private int amount;
}
