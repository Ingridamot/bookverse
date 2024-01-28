package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;


public interface BookDao { //Dao atlieka duombazes logikos funkcijas, duomenu saugojimas, trynimas, atnaujinimas ir panasios operacijos
    void save(Book book);

    void update(Book book);

    List<Book> getAll();

    Page<Book> getPage(Pageable pageable);

    Book getBookByUUID(UUID id);

    void deleteBookByUUID(UUID id);
}
