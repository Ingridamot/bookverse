package lt.codeacademy.bookverse;

public final class HttpEndpoints {

    public static final String PUBLIC_WORKSPACE = "/public";
    public static final String PRIVATE_WORKSPACE = "/private";
    public static final String BOOKS = "/books";
    public static final String BOOK_LIST = PUBLIC_WORKSPACE + "/books";
    public static final String BOOKS_CREATE = PRIVATE_WORKSPACE + BOOKS + "/create";
    public static final String BOOKS_UPDATE = PRIVATE_WORKSPACE + BOOKS + "/{bookId}/update";
    public static final String BOOKS_DELETE = PRIVATE_WORKSPACE + BOOKS + "/{bookId}/delete";

    public static final String CART = PUBLIC_WORKSPACE + "/cart";

    public static final String USER_REGISTRATION = PUBLIC_WORKSPACE + "/users";
    public static final String USER_CREATE = USER_REGISTRATION + "/create";
}

