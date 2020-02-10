package com.rakuten.first.demo.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.first.demo.domain.Publisher;
import com.rakuten.first.demo.service.BookService;
import com.rakuten.first.demo.service.PublisherService;


@RestController
public class PublisherController {
	@Autowired
	PublisherService service;
	@Autowired
	BookService bookservice;
	

	 @RequestMapping(method=RequestMethod.GET,value="/products")
	@GetMapping("/publisher")
	public List<Publisher> getAllPublisher() {
		return service.findAll();
	}

	@GetMapping("/publisher/{id}") // URI path template
	public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") int id) {
		Publisher p = service.getByBookId(id);
		if (p != null) {
			return new ResponseEntity<Publisher>(p, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<Publisher>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/publisher")
	public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher toBeAdded) {
		try {
			System.out.println(toBeAdded.getId() ); 
			int id = service.addPublisherToBook(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/publisher/" + id));
			return new ResponseEntity<Publisher>(toBeAdded,headers,HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<Publisher>(HttpStatus.BAD_REQUEST);
		}
	}

	
}