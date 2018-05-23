package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Artist;

public interface ArtistDAO {
	
	public ArrayList<Artist> getAll();
	public Artist getById(int id);
	public Artist addArtist(String name);
	public void updateArtist(int id, String name);
	public ArrayList<Artist> getAllStoredProc();
}
