package lt.codeacademy.bookverse.book.dao;

import lt.codeacademy.bookverse.common.book.dao.BookJPADao;
import lt.codeacademy.bookverse.jpa.repositories.BookRepository;
import lt.codeacademy.bookverse.jpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookJPADaoTest {

  @Test
  void save_FillsBookWithUUIDAndCallsRepository() {
    var repository = mock(BookRepository.class);
    var bookDao = new BookJPADao(repository);
    var book = Book.builder()
      .bookCategories(new HashSet<>())
      .title("Altoriu sesely")
      .author("Vincas mykolaitis-putinas")
      .price(BigDecimal.valueOf(0))
      .amount(1)
      .build();

    when(repository.findByBookId(any(UUID.class))).thenReturn(Optional.of(book));

    bookDao.save(book);

    assertNotNull(book.getBookId());
    verify(repository).save(any(Book.class));
  }

  @Test
  void getByUUID_ReturnsABookByUUID() {
    var repository = mock(BookRepository.class);
    var bookDao = new BookJPADao(repository);
    var uuid = UUID.randomUUID();
    var book = Book.builder().bookId(uuid).build();

    when(repository.findByBookId(uuid))
      .thenReturn(Optional.of(book));

    var actual = bookDao.getBookByUUID(uuid);

    assertEquals(actual.get(), book);
  }
}

