package lt.codeacademy.bookverse.jpa.repositories;

import lt.codeacademy.bookverse.jpa.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
