package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.masai.models.Books;
import com.masai.models.MyErrors;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<MyErrors> bookNotFoundException(BookNotFoundException bne,WebRequest wrq){
		
		MyErrors err=new MyErrors();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMag(bne.getMessage());
		err.setDetails(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrors>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrors> methodArgumentNotValidEx(MethodArgumentNotValidException me){
		
		MyErrors err=new MyErrors();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMag("Validation Errors...");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrors>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrors> noHandlerEx(NoHandlerFoundException ne,WebRequest wrq){
		
		MyErrors err=new MyErrors();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMag("Wrong uri! Enter the valid uri...");
		err.setDetails(wrq.getDescription(false));
		
		return new ResponseEntity<MyErrors>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	


}
