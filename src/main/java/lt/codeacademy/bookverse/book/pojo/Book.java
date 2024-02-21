package lt.codeacademy.bookverse.book.pojo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID bookId;
    private String title;
    private String author;
    private BigDecimal price;
    private int amount;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER) // nesikreipt atskirai į duomenų bazę, kad gauti susijusių objektų duomenis , tai su FetchType viskas bus užkrauta iš kart
    private Set<BookCategory> bookCategories = new HashSet<>();
}
