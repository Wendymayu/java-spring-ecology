create table t_book(
    id bigint auto_increment primary key not null,
    book_name varchar(512),
    author varchar(512),
    publisher varchar(512),
    published_date date
);