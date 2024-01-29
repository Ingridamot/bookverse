package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
@Primary
public class BookJPADao implements BookDao{

    BookRepository repository;

    @Autowired
    public BookJPADao(BookRepository bookRepository) {
        this.repository = bookRepository;
    }
    @Override
    public void save(Book book) {
        book.setBookId(UUID.randomUUID());
        repository.save(book);
    }

    @Override
    public void update(Book book) {
        repository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Book> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Book> getBookByUUID(UUID id) {
        return repository.findByBookId(id);
    }

    @Override
    public void deleteBookByUUID(UUID id) {
        repository.deleteBookByBookId(id);

    }
}
