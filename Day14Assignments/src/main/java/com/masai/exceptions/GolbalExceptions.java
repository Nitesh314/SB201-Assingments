package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GolbalExceptions {

	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<MyErrorDeatils> myIdNotFoundException(InvalidIdException ie, WebRequest wrq){
		
		MyErrorDeatils err=new MyErrorDeatils();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(ie.getMessage());
		err.setDetails(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrorDeatils>(err, HttpStatus.NOT_FOUND);
	}
	
 //*****************************************************************************************************************  
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyErrorDeatils> booksNotFoundException(BookNotFoundException be,WebRequest wrq){
		
		MyErrorDeatils err=new MyErrorDeatils();
		
	    err.setTimeStamp(LocalDateTime.now());
	    err.setMsg(be.getMessage());
	    err.setDetails(wrq.getDescription(false));
	    
		
	   return new ResponseEntity<MyErrorDeatils>(err, HttpStatus.NOT_FOUND);
	}
	
//***********************************************************************************************************************
	
	@ExceptionHandler(BookNotCreated.class)
	public ResponseEntity<MyErrorDeatils> bookNotCreatedEx(BookNotCreated be, WebRequest wrq){
		
		MyErrorDeatils err=new MyErrorDeatils();
		
		 err.setTimeStamp(LocalDateTime.now());
		    err.setMsg(be.getMessage());
		    err.setDetails(wrq.getDescription(false));
		    
			
		   return new ResponseEntity<MyErrorDeatils>(err, HttpStatus.NOT_FOUND);
		
	}
	
//***********************************************************************************************************************
	
	@ExceptionHandler(UpdatedBookEx.class)
	public ResponseEntity<MyErrorDeatils> UpdatedBookEx(UpdatedBookEx be, WebRequest wrq){
		
		MyErrorDeatils err=new MyErrorDeatils();
		
		 err.setTimeStamp(LocalDateTime.now());
		    err.setMsg(be.getMessage());
		    err.setDetails(wrq.getDescription(false));
		    
			
		   return new ResponseEntity<MyErrorDeatils>(err, HttpStatus.MOVED_PERMANENTLY);
		
	}
	
//*************************************************************************************************************************
	
	@ExceptionHandler(BookNotDeleted.class)
	public ResponseEntity<MyErrorDeatils> BookNotDeleted(BookNotDeleted bde, WebRequest wrq){
		
		MyErrorDeatils err=new MyErrorDeatils();
		
		 err.setTimeStamp(LocalDateTime.now());
		    err.setMsg(bde.getMessage());
		    err.setDetails(wrq.getDescription(false));
		    
			
		   return new ResponseEntity<MyErrorDeatils>(err, HttpStatus.NOT_MODIFIED);
		
	}
	
//***********************uri not found ex*********************************************************************************************************	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDeatils> NoHandlerFoundException(NoHandlerFoundException nhe, WebRequest wrq){
		
		MyErrorDeatils err=new MyErrorDeatils();
		
		 err.setTimeStamp(LocalDateTime.now());
		    err.setMsg(nhe.getMessage());
		    err.setDetails(wrq.getDescription(false));
		    
			
		   return new ResponseEntity<MyErrorDeatils>(err, HttpStatus.NOT_MODIFIED);
		
	}
	
	
	
}
