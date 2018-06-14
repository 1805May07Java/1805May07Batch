package com.ex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ex.beans.Turtle;

public class TurtleServiceImpl implements TurtleService{

	static ArrayList<Turtle> turtles = new ArrayList<Turtle>();
	
	static { 
		turtles.add(new Turtle("Gary", "green", "snails?" , "weapon"));
		turtles.add(new Turtle("why", "did i", "use turtles", "as an example"));
	}
	@Override
	public Turtle add(Turtle t) {
		turtles.add(t);
		return t;
	}

	@Override
	public List<Turtle> getAll() {
		return turtles;
	}

	@Override
	public Turtle getOne(String name) {
		// TODO Auto-generated method stub
		Optional<Turtle> tur = turtles.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst();
		if(tur.isPresent()) {
			return tur.get();
		}
		return null;
	}

	@Override
	public Turtle update(Turtle t) {
		// TODO Auto-generated method stub
		return null;
	}

}
