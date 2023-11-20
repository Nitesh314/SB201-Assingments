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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exceptions.BookNotCreated;
import com.masai.exceptions.BookNotDeleted;
import com.masai.exceptions.BookNotFoundException;
import com.masai.exceptions.InvalidIdException;
import com.masai.exceptions.UpdatedBookEx;
import com.masai.models.Book;
import com.masai.models.BooksDTO;

@RestController
@RequestMapping("/bookservice")
public class BookServiceController {
	
	private List<Book> bList=new ArrayList<>();
	private List<BooksDTO> lBT=new ArrayList<>();
	
	 //convert Book to BookDTO
	public List<BooksDTO> converBookToBooksDTO(){
		
		for(Book b:bList) {
			lBT.add(new BooksDTO(b.getName(),b.getAuthor(),b.getPublication(),b.getCategory(),b.getPages(),b.getPrice()));
		}
		
		return lBT;
		
	}
	
	
//***********GetAllBooks API************************************************************************************************************************************************	
		
	    @GetMapping("/author/books")
	    public ResponseEntity<List<Book>> getAllBooks(){
	    	
	    	if(bList.isEmpty()) {
	    		throw new BookNotFoundException("Sorry!! we don't have books...");
	    	}
	    	return new ResponseEntity<List<Book>>(bList,HttpStatus.OK);
	    	
	    }
	    
	    
 //***********getBoookByID ApI****************************************************************************************************************   
	    
		
	    @GetMapping("/author/books/{bookId}")
	    public ResponseEntity<Book> getBookById(@PathVariable Integer bookId) throws InvalidIdException{
	    	
	    	
	    	
	    	
	    	for(Book b:bList) {
	    		
	    		if(b.getBookId()==bookId) {
	    			
	    			Book book=new Book(b.getBookId(),b.getName(),b.getAuthor(),b.getPublication(),b.getCategory(),b.getPages(),b.getPrice(),b.getAuthor_no());
	    			
	    			return new ResponseEntity<Book>(book,HttpStatus.OK);
	    		}
	    	}
	    	
	    	throw new InvalidIdException("Book not found for bookId :"+bookId);
	    	
	    	
	    }
	    
	    
//**************createBook API*********************************************************************************************************************************    
	    
	    @PostMapping("/author/books")
	    public ResponseEntity<String> createBook(@RequestBody Book book){
	        
	    	
	    	if(bList!=null) {
	           
	    		bList.add(book);
	    		
	    		return new ResponseEntity<String>("Book Printed successfully...",HttpStatus.CREATED);
	    	}else {
	    		throw new BookNotCreated("Not created.....");
	    	}
	    	
	    }
	    
	 
//*************updateBook API***********************************************************************************************************************************  
	  
	    @PutMapping("/author/books/{bookId}")
	    public ResponseEntity<String> updatedBook(@PathVariable Integer bookId,@RequestBody Book upB){
	        
	    	if(bList==null) {
	    		throw new BookNotFoundException("Sorry!! we don't have books...");
	    	}else {
	    	
		    	for(Book b:bList) {
		    		
		    		if(b.getBookId()==bookId) {
		    			b.setName(upB.getName());
		    			b.setAuthor(upB.getAuthor());
		    			b.setAuthor_no(upB.getAuthor_no());
		    			b.setCategory(upB.getCategory());
		    			b.setPages(upB.getPages());
		    			b.setPrice(upB.getPrice());
		    			b.setPublication(upB.getPublication());
		    		   
		    			return new ResponseEntity<String>("Book details Updated Successfully...",HttpStatus.OK);
		    		}
		    		
		    	}
		    	throw new UpdatedBookEx("Book Not Updated... Beacause BookId :"+bookId+" Not Found");
	    	}
	    	
	    	
	    	
	    }
	 
	    
	    
	//*************deleteBookByID API*******************************************************************************************************************************
	 
	    @DeleteMapping("/author/books/{bookId}")
	    public ResponseEntity<String> bookDeleted(@PathVariable Integer bookId){
	    	
	    	
	    	boolean flag=bList.removeIf(b->b.getBookId()==bookId);
	    	
	    	if(flag) {
	    		return new ResponseEntity<String>("Book Deleted SucceFully...",HttpStatus.OK);
	    	}else {
	    		throw new BookNotDeleted("Book Not Deleted... Because bookId : "+bookId+" Not Found...");    	
	    	}
	    	

	    }
	    
		
//**************************************reader api************************************************************************************************		
		
	

	    
//***********GetAllBooksDTO API************************************************************************************************************************************************	
		
	    @GetMapping("/reader/books")
	    public ResponseEntity<List<BooksDTO>> getAllBookss(){
	 
	    	if(lBT.isEmpty()) {
	    		converBookToBooksDTO();
	    	}
	    	
	    	if(lBT.isEmpty()) {
	    		throw new BookNotFoundException("Sorry!! we don't have books...");
	    	}else {
	    
	    		return new ResponseEntity<List<BooksDTO>>(lBT,HttpStatus.OK);
	    	}
	    	
	    	
	    }
	    

//***********getBoooksDTOByID ApI****************************************************************************************************************   
	    
		
	    @GetMapping("/reader/books/{bookId}")
	    public ResponseEntity<BooksDTO> getBookByIds(@PathVariable Integer bookId) throws InvalidIdException{
	    	
	    	
	    	if(bList!=null) {
	    	
	    	for(Book b:bList) {
	    		
	    		if(b.getBookId()==bookId) {
	    			
	    			BooksDTO bt=new BooksDTO(b.getName(),b.getAuthor(),b.getPublication(),b.getCategory(),b.getPages(),b.getPrice());
	    			
	    			
	    			
	    			return new ResponseEntity<BooksDTO>(bt,HttpStatus.OK);
	    		}
	    	}
	    }
	    	
	    	throw new InvalidIdException("Book not found for bookId :"+bookId);
	    	
	    	
	    }
	    
	    
	 
	    
	    
}
