package lt.codeacademy.bookverse.fakes;

import lombok.Getter;
import lt.codeacademy.bookverse.book.dao.BookDao;
import lt.codeacademy.bookverse.book.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FakeBookDao implements BookDao {

    private HashMap<UUID, Book> storage;

    public FakeBookDao() {
        this.storage = new HashMap<>();
    }

    @Override
    public void save(Book book) {
        book.setId(storage.size() + 1);
        storage.put(book.getBookId(), book);
    }

    @Override
    public void update(Book book) {
        storage.put(book.getBookId(), book);
    }

    @Override
    public List<Book> getAll() {
        return storage.values().stream().toList();
    }

    @Override
    public Page<Book> getPage(Pageable pageable) {
        return Page.empty();
    }

    @Override
    public Optional<Book> getBookByUUID(UUID id) {
        return Optional.of(storage.get(id));
    }

    @Override
    public void deleteBookByUUID(UUID id) {
        storage.remove(id);
    }


}
