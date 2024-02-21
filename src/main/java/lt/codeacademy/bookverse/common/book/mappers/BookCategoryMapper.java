package lt.codeacademy.bookverse.common.book.mappers;


import lt.codeacademy.bookverse.jpa.entities.BookCategory;
import lt.codeacademy.bookverse.common.mapper.Mapper;
import lt.codeacademy.bookverse.common.book.dto.BookCategoryDto;
import org.springframework.stereotype.Component;

@Component
public class BookCategoryMapper implements Mapper<BookCategory, BookCategoryDto> {


    @Override
    public BookCategoryDto toDto(BookCategory entity) {
        return BookCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public BookCategory fromDto(BookCategoryDto bookCategoryDto) {
        return BookCategory.builder()
                .id(bookCategoryDto.getId())
                .name(bookCategoryDto.getName())
                .build();
    }
}
