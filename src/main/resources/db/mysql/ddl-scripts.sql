DROP TABLE IF EXISTS BOOK;

CREATE TABLE BOOK (
                         id int primary key auto_increment,
                         book_id varchar(36) NOT NULL,
                         title varchar(60) NOT NULL,
                         author varchar(60) NOT NULL,
                         price decimal(20, 2) NOT NULL ,
                         amount int NOT NULL
);