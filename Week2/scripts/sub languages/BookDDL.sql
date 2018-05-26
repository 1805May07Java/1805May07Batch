create table genre
(
    Genre_id number(10) primary key,
    Name varchar2(256) unique not null
);

create table book
(
    Book_id number(10) primary key, 
    ISBN varchar2(10)  unique not null,
    Title varchar2(256) not null,
    Price number(6,2) not null,
    Genre number(10),
    constraint fk_book_genre foreign key (genre) references genre(genre_id)
);

create table author
(
  author_id number(20) primary key,
  firstname varchar2(50) not null,
  lastname varchar2(50) not null,
  Bio varchar2(1000)
);

create table book_author
(
  book_id number(20),
  author_id number(20),
  primary key (book_id, author_id),
  foreign key (book_id) references book(book_id),
  foreign key (author_id) references author(author_id)
);

--------------------------- FIRST LOOK INTO PL/SQL ------------------------------------------------
-- SEQUENCES

create sequence book_seq
start with 100
increment by 1;

create sequence auth_seq;

-- TRIGGERS

create or replace trigger book_seq_trigger -- naming trigger
before insert on book -- when is it happening
for each row -- how often
begin
    -- where meat of trigger resides
    select book_seq.nextVal into :new.book_id from dual;
end;


/

select * from dual;
create sequence test
start with 1
increment by 1;

select * from book;
-- lets test this out 
insert into book(isbn, title, price) values('0009992221', 'SQL Basics', 10.99);

commit;