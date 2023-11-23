package com.masai.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.masai.models.MyError;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noHandelrFoundException(NoHandlerFoundException ne,WebRequest weq){
		
		MyError err=new MyError();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg("Not_Found");
		err.setDetails(weq.getDescription(false));
		
		return new ResponseEntity<MyError>(err,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> methodArgumentNotValidEx(MethodArgumentNotValidException mae){
        
        MyError err=new MyError();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg("Validation Errors");
		err.setDetails(mae.getBindingResult().getFieldError().getDefaultMessage());
		
		
//		List<String> errorMessages = new ArrayList<>();
//	    for (FieldError fieldError : mae.getBindingResult().getFieldErrors()) {
//	        errorMessages.add(fieldError.getDefaultMessage());
//	    }
//	    
//	    err.setDetails(errorMessages);
		
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyError>productNotFoundException(ProductException pe,WebRequest weq){
		
        MyError err=new MyError();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(pe.getMessage());
		err.setDetails(weq.getDescription(false));
		
		
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exception(Exception e,WebRequest weq){
		
        MyError err=new MyError();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDetails(weq.getDescription(false));
		
		
		return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
		
	}

}
