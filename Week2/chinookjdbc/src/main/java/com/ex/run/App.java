package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.ArtistDAO;
import com.ex.dao.ArtistDAOImpl;
import com.ex.pojos.Artist;

public class App {

	public static void main(String[] args) {
		ArtistDAO dao = new ArtistDAOImpl();
		
		ArrayList<Artist> artists = dao.getAll();
		for(Artist a : artists) {
			System.out.println(a.toString());
		}
	}

}
