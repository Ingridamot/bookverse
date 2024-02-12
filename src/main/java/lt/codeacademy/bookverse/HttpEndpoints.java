package lt.codeacademy.bookverse;

public final class HttpEndpoints {

    public static final String BOOKS = "/books";
    public static final String BOOKS_CREATE = BOOKS + "/create";
    public static final String BOOKS_UPDATE = BOOKS + "/{bookId}/update";
    public static final String BOOKS_DELETE = BOOKS + "/{bookId}/delete";

}

