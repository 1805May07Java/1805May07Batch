create table GENRE
(
    GENRE_ID number (10) primary key,
    GENRE_NAME varchar2(256) unique not null
);

create table BOOK
(
    BOOK_ID number(10) primary key,
    ISBN varchar2(10) unique not null,
    TITLE varchar2(256) not null,
    PRICE number(6,2) not null,
    GENRE number(10),
    constraint fk_book_genre foreign key (genre) references genre(genre_id)
);

create table AUTHOR(
    AUTHOR_ID Number(10) primary key,
    FIRST_NAME varchar2(20) not null,
    LAST_NAME varchar2(20),
    BIO varchar2(200)
);

create table BOOK_AUTHOR
(
  BOOK_ID number(10),
  AUTHOR_ID number (10),
  constraint PK_BOOKAUTHOR primary key
  (
      BOOK_ID,
      AUTHOR_ID
  ),
  foreign key (BOOK_ID) references BOOK (BOOK_ID),
  foreign key (AUTHOR_ID) references AUTHOR (AUTHOR_ID)
  
);

create sequence book_seq
start with 1;

create sequence author_seq
start with 1;

create sequence genre_seq
start with 1;

create or replace trigger book_seq_trig
before insert on book
for each row 
begin
select book_seq.nextVal into :new.book_id from dual;
end;
/

create or replace trigger author_seq_trig
before insert on author
for each row
begin
select author_seq.nextVal into :new.author_id from dual;
end;
/

create or replace trigger genre_seq_trig
before insert on genre
for each row
begin
select genre_seq.nextVal into :new.genre_id from dual;
end;
/






