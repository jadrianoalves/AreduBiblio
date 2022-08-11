package com.aredu.biblio.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aredu.biblio.erros.dto.DefaultError;

@ControllerAdvice
public class ApplicationExceptionHandler {

	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity handleException(Exception e) {
		
		DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Erro na sua requisição");
		return new ResponseEntity(erro, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity handleBookException(Exception e) {
		
		DefaultError erro = new DefaultError(HttpStatus.BAD_REQUEST.value(), "Book não encontrado");
		return new ResponseEntity(erro, HttpStatus.BAD_REQUEST);
	}
}
