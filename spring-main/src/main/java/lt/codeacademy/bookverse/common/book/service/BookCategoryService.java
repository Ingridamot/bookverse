package lt.codeacademy.bookverse.common.book.service;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.jpa.repositories.BookCategoryRepository;
import lt.codeacademy.bookverse.common.book.dto.BookCategoryDto;
import lt.codeacademy.bookverse.common.book.mappers.BookCategoryMapper;
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

