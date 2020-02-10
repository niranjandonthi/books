//
package com.rakuten.first.demo.web;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.first.demo.dal.BookDAO;
import com.rakuten.first.demo.domain.Book;
import com.rakuten.first.demo.service.BookService;
//import com.rakuten.first.demo.service.BookServiceInMemImpl;
//import com.rakuten.first.demo.service.PublisherService;
import com.rakuten.first.demo.domain.Book;
//import com.rakuten.first.demo.domain.Publisher;
import com.rakuten.first.demo.domain.Book;
import com.rakuten.first.demo.service.BookService;
import com.rakuten.first.demo.service.NoSuchBookException;
@RestController
@CrossOrigin
public class BookController {
	@Autowired
	BookService service;

//	 @RequestMapping(method=RequestMethod.GET,value="/Books")
	@GetMapping("/Books")
	public List<Book> getAllBooks() {
		System.out.println(service.findByAll());
		return service.findByAll();
	}

	@GetMapping("/Books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book p = service.findById(id);
		if (p != null) {
			return new ResponseEntity<Book>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/Books")
	public ResponseEntity<Book> addBook(@RequestBody Book toBeAdded) {
		try {
			int id = service.addbook(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/Books/" + id));
			return new ResponseEntity<Book>(headers, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/Books/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable("id") int id) {

		try {
			service.removebook(id);
			return new ResponseEntity<Book>(HttpStatus.OK);
		}

		catch (IllegalArgumentException e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
}
////	@Autowired BookService service;
////
////	  @Autowired PublisherService publisherService;
////
//////	  @GetMapping("/Publisher/{id}/books")
//////	  public ResponseEntity<List<Book>> getBooksForPublisher(@PathVariable("id") int bookId) {
//////	    Book p = bookService.findById(bookId);
//////	    if (p == null) {
//////	      return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
//////	    }
//////	    List<Book> books = bookService.findByAll();
//////	    return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
//////	  }
////	  @GetMapping("/books")
////		public List<Book> getAllBook()
////		{
////			return service.findByAll();
////		}
////		@GetMapping("/book/{pubid}")
////		public ResponseEntity<Book> getBookById(@PathVariable("pubid")int id)
////		{
////			Book p = service.findById(id);
////			if(p  != null )
////			{
////				return new ResponseEntity<Book>(p,HttpStatus.OK);
////			}
////			else
////			{
////				return new ResponseEntity<Book>(p,HttpStatus.NOT_FOUND);
////				
////			}
////			//return p;
////			
////		}
////		
////		
////		@PostMapping("/book")
////		public ResponseEntity<Book> addBook(@RequestBody Book toBeAdded)
////		{
////			try {
////				int id = service.addbook(toBeAdded);
////				System.out.println("add_pub"+id ); 
////				HttpHeaders headers = new HttpHeaders();
////				headers.setLocation(URI.create("/publisher/"+id));
////				return new ResponseEntity<Book>(toBeAdded,headers,HttpStatus.CREATED);
////				
////			}
////			catch(IllegalArgumentException e)
////			{
////				return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
////			}
////		}
////		
////
////}
////
//////	  @PostMapping("/Books/publisher/{id}")
//////	  public ResponseEntity<Book> addBooksTopublisher(
//////	      @PathVariable("id") int BookId, @RequestBody Book book) {
//////	    try {
//////	      int id = bookService.addbook();
//////	      HttpHeaders headers = new HttpHeaders();
//////	      headers.setLocation(URI.create("/Books/" + BookId + "/reviews/" + id));
//////	      return new ResponseEntity<>(review, headers, HttpStatus.CREATED);
//////	    } catch (NoSuchBookException e) {
//////	      return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
//////	    }
//////	  }
//
//
//
