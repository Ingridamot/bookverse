package lt.codeacademy.bookverse.book;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.book.mapper.BookJDBCRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookJDBCDao implements BookDao{

    private final JdbcTemplate jdbcTemplate;
    private final BookJDBCRowMapper bookJDBCRowMapper;
    @Override
    public void save(Book book) {
        book.setBookId(UUID.randomUUID());
        jdbcTemplate.update("INSERT INTO BOOK(BOOK_ID, TITLE, AUTHOR, PRICE, AMOUNT) VALUES (?, ?, ?, ?, ?)",
        book.getBookId(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getAmount());
    }

    @Override
    public void update(Book book) {
        jdbcTemplate.update("UPDATE BOOK SET title = ?, author = ?, price = ?, amount = ? WHERE book_id = ?",
        book.getTitle(), book.getAuthor(), book.getPrice(), book.getAmount(), book.getBookId());

    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query(
            "SELECT * FROM BOOK", bookJDBCRowMapper);

    }

    @Override
    public Book getBookByUUID(UUID id) {
        final List<Book> books = jdbcTemplate.query(
             String.format("SELECT * FROM BOOK WHERE book_id = '%s'", id.toString()), bookJDBCRowMapper);

        return books.get(0);
    }

    @Override
    public void deleteBookByUUID(UUID id) {
        jdbcTemplate.execute(String.format("DELETE FROM BOOK WHERE BOOK_ID = '%s'", id.toString()));
    }
}
