package com.rakuten.first.demo.ui;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakuten.first.demo.domain.Book;
import com.rakuten.first.demo.service.BookService;

//@Component
public class BookConsoleUI {
	
	 BookService service;

	
		 @Autowired
		public void setService(BookService service) {
	    this.service = service;
	  }
		 public void createBookWithUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  the name");
		String name =sc.next();
		System.out.println("Enter the genre");
		String genre=sc.next();
		System.out.println("Enter the number of pages");
		int pages=sc.nextInt();
		System.out.println("Enter the price");
		float price=sc.nextFloat();
		Book b = new Book(name, genre, pages, price);
		int id = service.addbook(b);
		System.out.println("Book created with id  "+id+"  name"+name+"  genre"+genre+"  number of pages"+pages+"  price"+price);
		
	}
		 
	

}
