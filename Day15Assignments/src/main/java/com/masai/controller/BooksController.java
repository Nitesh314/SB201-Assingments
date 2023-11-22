package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BookNotFoundException;
import com.masai.models.Books;

@RestController
public class BooksController {
	
	private List<Books> bList=new ArrayList<>();
	
	
//***********************************************************************************************************
	@GetMapping("/books")
	public ResponseEntity<List<Books>>getAllBooksDetails() throws BookNotFoundException{
		
		if(bList.isEmpty()) {
			throw new BookNotFoundException("Sorry !! No Books found...");
		}else {
			return new ResponseEntity<List<Books>>(bList,HttpStatus.OK);
		}
		
	}
	
//***********************************************************************************************************		

	@GetMapping("/books/{bookId}")
	 public ResponseEntity<Books>getBookById(@PathVariable("bookId") Integer id)throws BookNotFoundException{
		
		for(Books b :bList) {
			if(b.getBookId()==id) {
				return new ResponseEntity<Books>(b,HttpStatus.OK);
				
			}
		}
		throw new  BookNotFoundException("Book not found by bookId: "+id);
		 
	 }
	
//***********************************************************************************************************		
 
	@PostMapping("/books")
	public ResponseEntity<String>createNewBooks(@RequestBody Books book) throws BookNotFoundException{
		
		String msg="Books Not Created...";
		if(bList.size()>=0) {
			bList.add(book);
			msg="Books Created Successfully...";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}else {
			throw new BookNotFoundException(msg);
		}
	}
	
	
//***********************************************************************************************************		
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String>deleteBooksById(@PathVariable("bookId") Integer id) throws BookNotFoundException{
		
	
		String msg="Book not found with bookid : ";
		
		for(Books b :bList) {
			if(b.getBookId()==id) {
				bList.remove(b);
				msg="Book deleted successfully...";
			    return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			}
		}
		throw new  BookNotFoundException(msg+id);
		    
					
		
		
		
	}

//*****************************************************************************************************8888
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<String>updateBooksById(@PathVariable("bookId") Integer id,@RequestBody Books book) throws BookNotFoundException{
		
	
		String msg="Book not found with bookid : ";
		
		for(Books b :bList) {
			if(b.getBookId()==id) {
			    
				b.setAuthor(book.getAuthor());
				b.setName(book.getName());
				b.setBookId(book.getBookId());
				b.setPrice(book.getPrice());
				
				msg="Book updated successfully...";
			    return new ResponseEntity<String>(msg,HttpStatus.OK);
				
			}
		}
		throw new  BookNotFoundException(msg+id);
		    
					
		
		
		
	}
	
	
}
