package lt.codeacademy.bookverse.book.mappers;


import lt.codeacademy.bookverse.common.mapper.Mapper;
import lt.codeacademy.bookverse.book.dto.BookCategoryDto;
import lt.codeacademy.bookverse.book.pojo.BookCategory;
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
