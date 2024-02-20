package lt.codeacademy.bookverse.book.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.book.mappers.BookMapper;
import lt.codeacademy.bookverse.book.pojo.Book;
import lt.codeacademy.bookverse.book.pojo.BookCategory;
import lt.codeacademy.bookverse.book.dao.BookCategoryRepository;
import lt.codeacademy.bookverse.book.dao.BookDao;
import lt.codeacademy.bookverse.book.dto.BookDto;
import lt.codeacademy.bookverse.book.exception.BookNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;
    private final BookCategoryRepository bookCategoryRepository;
    private final BookMapper mapper;

    @Transactional
    public void saveBook(BookDto bookDto) {
        final Book book = mapper.fromDto(bookDto);
        final BookCategory bookCategory = bookCategoryRepository.getReferenceById(bookDto.getCategoryIds().get(0));

        book.getBookCategories().add(bookCategory);

        bookDao.save(book);
    }

    @Transactional
    public BookDto save(BookDto bookDto) {
        final Book book = mapper.fromDto(bookDto);
        final BookCategory bookCategory = bookCategoryRepository.getReferenceById(bookDto.getCategoryIds().get(0));

        book.getBookCategories().add(bookCategory);

        return mapper.toDto(bookDao.save(book));
    }

    public void updateBook(BookDto bookDto) {
        bookDao.update(mapper.fromDto(bookDto));
    }

    public Page<BookDto> getAllBooksPage(Pageable pageable) {
        return bookDao.getPage(pageable).map(book -> mapper.toDto(book));
    }

    public BookDto getBookByUUID(UUID id) {
        return bookDao.getBookByUUID(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Transactional
    public void deleteBookByUUID(UUID id) {
        bookDao.deleteBookByUUID(id);
    }
}
