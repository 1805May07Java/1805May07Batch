package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.ArtistDAO;
import com.ex.dao.ArtistDaoImpl;
//import com.ex.dao.GenreDAO;
//import com.ex.dao.GenreDaoimpl;
import com.ex.pojos.Artist;
//import com.ex.pojos.Genre;

public class App {
	public static void main(String[] args) {
		/*ArtistDAO dao = new ArtistDaoImpl();

		ArrayList<Artist> artists = dao.getAll();
		for (Artist a : artists){
			System.out.println(a.toString());
		}*/

		/*GenreDAO dao = new GenreDaoimpl();

		ArrayList<Genre> genres = dao.getAll();
		for (Genre a : genres){
			System.out.println(a.toString());*/

		/*ArtistDAO dao = new ArtistDaoImpl();

		Artist artists = dao.getById(42);
		System.out.println(artists.toString());*/

		/*ArtistDAO dao = new ArtistDaoImpl();
		System.out.println(dao.addArtist("Bowling for Soup"));*/

		/*ArtistDAO dao = new ArtistDaoImpl();
		dao.updateArtist(277, "BFS");*/

		ArtistDAO dao = new ArtistDaoImpl();
		ArrayList<Artist> artists = dao.getAllStoredProc();
		for (Artist a : artists){
			System.out.println(a.toString());



		}
	}
}
