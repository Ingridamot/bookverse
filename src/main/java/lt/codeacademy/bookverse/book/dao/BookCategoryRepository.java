package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.book.pojo.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
