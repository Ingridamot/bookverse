INSERT INTO BOOK(BOOK_ID, TITLE, AUTHOR, PRICE, AMOUNT)
VALUES
    ('260f7043-d0bf-4d99-b143-6ee555685561', 'The Wind''s Twelve Quarters', 'Mr. Vannesa Mraz', 25.0, 38),
    ('260f7043-d0bf-4d99-b143-6ee555685562', 'The Grapes of Wrath', 'Birdie Koelpin', 78.0, 20),
    ('260f7043-d0bf-4d99-b143-6ee555685563', 'Postern of Fate', 'Jacinda Effertz Jr.', 78.0, 15),
    ('260f7043-d0bf-4d99-b143-6ee555685564', 'Time To Murder And Create', 'Mrs. Nickolas Schuppe', 45.0, 70),
    ('260f7043-d0bf-4d99-b143-6ee555685565', 'Fair Stood the Wind for France', 'Allan Fisher', 25.0, 40),
    ('260f7043-d0bf-4d99-b143-6ee555685566', 'The Last Temptation', 'Leon Yundt', 30.0, 38),
    ('260f7043-d0bf-4d99-b143-6ee555685567', 'The Glory and the Dream', 'Bee Orn', 15.0, 70),
    ('260f7043-d0bf-4d99-b143-6ee555685568', 'Dulce et Decorum Est', 'Loyd Sawayn', 85.0, 10),
    ('260f7043-d0bf-4d99-b143-6ee555685569', 'Dance Dance Dance', 'Pearline Beier', 17.0, 38),
    ('260f7043-d0bf-4d99-b143-6ee555685570', 'Dulce et Decorum Est', 'Nathan Boyer', 25.0, 46),
    ('260f7043-d0bf-4d99-b143-6ee555685571', 'Those Barren Leaves, Thrones, Dominations', 'Dr. Merlene Murphy', 10.0, 79),
    ('260f7043-d0bf-4d99-b143-6ee555685572', 'Beneath the Bleeding', 'Kendrick Reichert', 99.0, 10),
    ('260f7043-d0bf-4d99-b143-6ee555685573', 'Carrion Comfort', 'Katerine Hamill', 67.0, 15),
    ('260f7043-d0bf-4d99-b143-6ee555685574', 'Pale Kings and Princes', 'Miss Serena Weber', 5.0, 89),
    ('260f7043-d0bf-4d99-b143-6ee555685575', 'East of Eden', 'Hildegarde Kling', 25.0, 38);

insert into BOOK_CATEGORY(NAME)
VALUES ('Fiction'),
       ('Thriller'),
       ('Mystery'),
       ('Romance');

insert into BOOK_BOOK_CATEGORIES(book_id, book_categories_id)
VALUES (1, 2),
       (2, 1);