package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
