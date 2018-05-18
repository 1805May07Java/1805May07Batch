package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.ArtistDAO;
import com.ex.dao.ArtistDAOImpl;
import com.ex.pojos.Artist;

public class App {

	public static void main(String[] args) {
		ArtistDAO dao = new ArtistDAOImpl();
		
		ArrayList<Artist> artists = dao.getAllStoredProc();
		for(Artist a : artists) {
			System.out.println(a.toString());
		}
//	dao.updateArtist(278, "another test");
//	 System.out.println(dao.getById(278).toString());
	}

}
