package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
