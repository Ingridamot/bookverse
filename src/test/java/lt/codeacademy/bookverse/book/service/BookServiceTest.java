package lt.codeacademy.bookverse.book.service;

import lt.codeacademy.bookverse.book.dao.BookCategoryRepository;
import lt.codeacademy.bookverse.book.dao.BookDao;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.mappers.BookMapper;
import lt.codeacademy.bookverse.book.pojo.Book;
import lt.codeacademy.bookverse.book.pojo.BookCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookCategoryRepository bookCategoryRepository;

    @Mock
    private BookDao bookDao;

    @Mock
    private BookMapper mapper;

    @InjectMocks
    private BookService service;

    @Test
    public void saveBook_savesABookAndSetsCategory() {
        var bookUUID = UUID.randomUUID();
        var categoryId = 123L;

        var bookDto = new BookDto(bookUUID, "Altoriu Seselyje", "Vincas mykolaitis Putinas", BigDecimal.valueOf(1.95), 1, List.of(categoryId));
        var book = new Book();

        when(bookCategoryRepository.getReferenceById(any())).thenReturn(new BookCategory());
        when(mapper.fromDto(bookDto)).thenReturn(book);

        service.saveBook(bookDto);

        verify(mapper).fromDto(eq(bookDto));
        verify(bookCategoryRepository).getReferenceById(eq(categoryId));
        verify(bookDao).save(eq(book));
    }
}
