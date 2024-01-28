package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where bookId = ?1")
    Book findByBookId(UUID id);

    void deleteBookByBookId(UUID id);
}
