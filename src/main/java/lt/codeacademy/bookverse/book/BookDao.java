package lt.codeacademy.bookverse.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDao { //Dao atlieka duombazes logikos funkcijas, duomenu saugojimas, trynimas, atnaujinimas ir panasios operacijos
    private List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> getAll() {
        return books;
    }
}

