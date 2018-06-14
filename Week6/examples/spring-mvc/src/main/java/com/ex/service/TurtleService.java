package com.ex.service;

import java.util.List;

import com.ex.beans.Turtle;

public interface TurtleService {

	Turtle add(Turtle t);
	List<Turtle> getAll();
	Turtle getOne(String name);
	Turtle update(Turtle t);
	
}
