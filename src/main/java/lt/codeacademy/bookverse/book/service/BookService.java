package lt.codeacademy.bookverse.book.service;

import lt.codeacademy.bookverse.mappers.BookMapper;
import lt.codeacademy.bookverse.book.Book;
import lt.codeacademy.bookverse.book.dao.BookDao;
import lt.codeacademy.bookverse.book.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BookService {
    private BookDao bookDao;
    private BookMapper mapper;

    @Autowired
    public BookService(BookDao bookDao, BookMapper mapper) {
        this.bookDao = bookDao;
        this.mapper = mapper;
    }

    public void saveBook(Book book) {
        bookDao.save(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public Page<BookDto> getAllBooksPage(Pageable pageable) {
        return bookDao.getPage(pageable).map(book -> mapper.toBookDto(book));
    }

    public BookDto getBookByUUID(UUID id) {
        return mapper.toBookDto(bookDao.getBookByUUID(id));
    }

    public void deleteBookByUUID(UUID id) {
        bookDao.deleteBookByUUID(id);
    }
}
