package lt.codeacademy.bookverse.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private BookDao bookDao;

    @Autowired
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void saveBook(Book book) {
        bookDao.save(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    public Book getBookByUUID(UUID id) {
        return bookDao.getBookByUUID(id);
    }

    public void deleteBookByUUID(UUID id) {
        bookDao.deleteBookByUUID(id);
    }
}

