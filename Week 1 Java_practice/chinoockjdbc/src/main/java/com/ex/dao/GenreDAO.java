package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Genre;

public interface GenreDAO {
	public ArrayList<Genre> getAll();
	public Genre getById(int id);
	public Genre addArtist(String name);
	public Genre updateArtist(int id, String name);
}
