package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.common.book.dao.BookJPADao;
import lt.codeacademy.bookverse.jpa.repositories.BookRepository;
import lt.codeacademy.bookverse.jpa.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookJPADaoIT {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private BookRepository bookRepository;

  @Test
  void save_persistsAGivenBook() {
    var bookDao = new BookJPADao(bookRepository);
    var book = Book.builder()
      .bookCategories(new HashSet<>())
      .title("Altoriu Sesely")
      .author("Vincas-Mykolaitis-Putinas")
      .price(BigDecimal.valueOf(0))
      .amount(1)
      .build();

    bookDao.save(book);

    var id = testEntityManager.getId(book, Long.class);
    assertTrue(id > 0);
    var savedBook = testEntityManager.find(Book.class, id);

    assertEquals(savedBook.getTitle(), book.getTitle());
    assertEquals(savedBook.getAuthor(), book.getAuthor());
    assertEquals(savedBook.getAmount(), book.getAmount());
    assertEquals(savedBook.getPrice(), book.getPrice());
    assertNotNull(savedBook.getBookId());
  }

  @Test
  void getByUUID_returnsABookByUUID() {
    var bookDao = new BookJPADao(bookRepository);
    var uuid = UUID.randomUUID();

    var book = Book.builder()
      .bookCategories(new HashSet<>())
      .title("altoriu sesely")
      .author("Vincas-mykolaitis-putinas")
      .price(BigDecimal.valueOf(0))
      .bookId(uuid)
      .amount(1)
      .build();

    var id = testEntityManager.getId(book, Long.class);
    assertEquals(0, id);

    testEntityManager.persistAndFlush(book);
    var savedBook = bookDao.getBookByUUID(uuid).get();

    assertEquals(savedBook.getTitle(), book.getTitle());
    assertEquals(savedBook.getAuthor(), book.getAuthor());
    assertEquals(savedBook.getAmount(), book.getAmount());
    assertEquals(savedBook.getPrice(), book.getPrice());
    assertTrue(savedBook.getId() > 0);
  }
}
