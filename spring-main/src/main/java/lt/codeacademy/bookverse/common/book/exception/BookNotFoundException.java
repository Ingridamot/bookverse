package lt.codeacademy.bookverse.common.book.exception;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Getter
public class BookNotFoundException extends RuntimeException {
    private final UUID bookUUID;
}
