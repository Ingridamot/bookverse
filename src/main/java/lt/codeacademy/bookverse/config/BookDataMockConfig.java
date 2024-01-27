package lt.codeacademy.bookverse.config;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lt.codeacademy.bookverse.book.Book;
import lt.codeacademy.bookverse.book.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BookDataMockConfig {

    private static final int MAX_COUNT = 10;

    private final BookService bookService;

    @Bean
    public Void initBooks() {
        var count = 0;
        final Faker faker = new Faker();
        while (MAX_COUNT >= count) {
            bookService.saveBook(
                    Book.builder()
                            .title(faker.book().title())
                            .author(faker.book().author())
                            .amount(faker.number().numberBetween(2, 99))
                            .price(faker.number().numberBetween(1, 100))
                            .build());
            count++;
        }
        return null;
    }
}
