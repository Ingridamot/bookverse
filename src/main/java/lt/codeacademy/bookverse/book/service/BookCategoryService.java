package lt.codeacademy.bookverse.book.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.book.dao.BookCategoryRepository;
import lt.codeacademy.bookverse.book.dto.BookCategoryDto;
import lt.codeacademy.bookverse.book.mappers.BookCategoryMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;
    private final BookCategoryMapper bookCategoryMapper;

    public Set<BookCategoryDto> getCategories() {
        return bookCategoryRepository.findAll().stream()
                .map(bookCategoryMapper::toDto)
                .collect(Collectors.toSet());
    }

}

