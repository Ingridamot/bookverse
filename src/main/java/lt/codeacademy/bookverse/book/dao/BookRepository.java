package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookId(UUID id);

    void deleteBookByBookId(UUID id);
}
