package lt.codeacademy.bookverse.book;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDao { //Dao atlieka duombazes logikos funkcijas, duomenu saugojimas, trynimas, atnaujinimas ir panasios operacijos
    private Map<UUID, Book> books = new HashMap<>();

    public void save(Book book) {
        final UUID uuid = UUID.randomUUID();
        book.setBookId(uuid);
        books.put(uuid, book);
    }

    public void update(Book book) {
        books.put(book.getBookId(), book);
    }

    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    public Book getBookByUUID(UUID id) {
        return books.get(id);
    }

    public void deleteBookByUUID(UUID id) {
        books.remove(id);
    }
}

