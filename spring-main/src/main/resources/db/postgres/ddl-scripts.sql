DROP TABLE IF EXISTS book;

CREATE TABLE book (
                         id SERIAL primary key,
                         book_id UUID NOT NULL,
                         title VARCHAR(60) NOT NULL,
                         author VARCHAR(60) NOT NULL,
                         price DECIMAL(20, 2) NOT NULL ,
                         amount INTEGER NOT NULL
);