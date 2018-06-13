package com.ex.run;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Author;
import com.ex.service.AuthorService;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		AuthorService service = (AuthorService) context.getBean("authorService", AuthorService.class);
		List<Author> authors = service.getAll();
		for(Author a : authors) {
			System.out.println(a.toString());
		}
		
		System.out.println(service.findByName("testingthisname"));
	}

}
