package lt.codeacademy.bookverse.book.mapper;

import lt.codeacademy.bookverse.book.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class BookJDBCRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Book.builder()
                .bookId(UUID.fromString(rs.getString("book_id")))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .price(rs.getDouble("price"))
                .amount(rs.getInt("amount"))
                .build();
    }
}
