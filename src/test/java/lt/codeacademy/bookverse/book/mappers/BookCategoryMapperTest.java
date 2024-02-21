package lt.codeacademy.bookverse.book.mappers;

import lt.codeacademy.bookverse.common.book.mappers.BookCategoryMapper;
import lt.codeacademy.bookverse.jpa.entities.BookCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookCategoryMapperTest {
    @Test
    public void toDTO_whenGivenValidBook_mapsToDto() {
        var categoryMapper = new BookCategoryMapper();

        var bookCategory = new BookCategory(123L, "food");
        var dto = categoryMapper.toDto(bookCategory);

        assertEquals(bookCategory.getName(), dto.getName());
        assertEquals(bookCategory.getId(), dto.getId());
    }
}
