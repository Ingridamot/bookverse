package lt.codeacademy.bookverse.common.book.dao;

import lt.codeacademy.bookverse.jpa.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface BookDao { //Dao atlieka duombazes logikos funkcijas, duomenu saugojimas, trynimas, atnaujinimas ir panasios operacijos
    Book save(Book book);

    void update(Book book);

    List<Book> getAll();

    Page<Book> getPage(Pageable pageable);

    Optional<Book> getBookByUUID(UUID id);

    void deleteBookByUUID(UUID id);
}
