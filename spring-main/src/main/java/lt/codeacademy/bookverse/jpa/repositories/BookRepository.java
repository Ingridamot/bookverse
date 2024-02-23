package lt.codeacademy.bookverse.jpa.repositories;

import lt.codeacademy.bookverse.jpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByBookId(UUID id);

    void deleteBookByBookId(UUID id);
}
