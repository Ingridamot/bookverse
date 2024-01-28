package lt.codeacademy.bookverse.book;

import org.springframework.stereotype.Repository;

import java.util.*;


public interface BookDao { //Dao atlieka duombazes logikos funkcijas, duomenu saugojimas, trynimas, atnaujinimas ir panasios operacijos
    void save(Book book);

    void update(Book book);

    List<Book> getAll();

    Book getBookByUUID(UUID id);

    void deleteBookByUUID(UUID id);
}
