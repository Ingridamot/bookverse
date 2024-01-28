package lt.codeacademy.bookverse.book;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.UUID;
@Repository
public class BookMockDao implements BookDao{
    private Map<UUID, Book> books = new HashMap<>();
    @Override
    public void save(Book book) {
        final UUID uuid = UUID.randomUUID();
        book.setBookId(uuid);
        books.put(uuid, book);
    }

    @Override
    public void update(Book book) {
        books.put(book.getBookId(), book);

    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBookByUUID(UUID id) {
        return books.get(id);
    }

    @Override
    public void deleteBookByUUID(UUID id) {
        books.remove(id);

    }
}
