DROP TABLE IF EXISTS BOOK;

DROP TABLE IF EXISTS BOOK_CATEGORY;

CREATE TABLE BOOK_CATEGORY
(
    id         BIGINT primary key auto_increment,
    name       varchar(20) NOT NULL
);

CREATE TABLE BOOK (
       id BIGINT primary key auto_increment,
       book_id UUID NOT NULL,
       title varchar(60) NOT NULL,
       author varchar(60) NOT NULL,
       price decimal(20, 2) NOT NULL,
       amount int NOT NULL
);

CREATE TABLE BOOK_BOOK_CATEGORIES
(
    book_id BIGINT NOT NULL,
    book_categories_id BIGINT NOT NULL
);