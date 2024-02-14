DROP TABLE IF EXISTS BOOK;

DROP TABLE IF EXISTS BOOK_CATEGORY;

CREATE TABLE BOOK_CATEGORY
(
    id   BIGINT primary key auto_increment,
    name varchar(20) NOT NULL
);

CREATE TABLE BOOK
(
       id       BIGINT primary key auto_increment,
       book_id  UUID           NOT NULL,
       title    varchar(60)    NOT NULL,
       author   varchar(60)    NOT NULL,
       price    decimal(20, 2) NOT NULL,
       amount   int            NOT NULL
);

CREATE TABLE BOOK_BOOK_CATEGORIES
(
    book_id             BIGINT NOT NULL,
    book_categories_id  BIGINT NOT NULL
);


DROP TABLE IF EXISTS users_authorities;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id           BIGINT primary key auto_increment,
    name         VARCHAR(20)  NOT NULL,
    surname      VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL,
    password     VARCHAR(500) NOT NULL,
    zip_code     VARCHAR(10)  NOT NULL,
    phone_number VARCHAR(12)  NOT NULL
);

CREATE TABLE authority
(
    id          BIGINT primary key auto_increment,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(2000)
);

CREATE TABLE users_authorities
(
    user_id      BIGINT,
    authority_id BIGINT
);