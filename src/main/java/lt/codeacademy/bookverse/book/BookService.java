package lt.codeacademy.bookverse.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }
}

