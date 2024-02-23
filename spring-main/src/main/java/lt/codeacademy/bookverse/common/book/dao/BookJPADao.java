package lt.codeacademy.bookverse.common.book.dao;

import lt.codeacademy.bookverse.common.book.exception.BookNotFoundException;
import lt.codeacademy.bookverse.jpa.entities.Book;
import lt.codeacademy.bookverse.jpa.repositories.BookRepository;
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
    public Book save(Book book) {
        UUID bookId = UUID.randomUUID();
        book.setBookId(bookId);

        repository.save(book);

        return repository.findByBookId(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
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
