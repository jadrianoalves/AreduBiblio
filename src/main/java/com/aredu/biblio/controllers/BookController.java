package com.aredu.biblio.controllers;

import java.util.Optional;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aredu.biblio.dto.BookModelDto;
import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/{bookCode}")
	public ResponseEntity<Object> getBook(@PathVariable(value ="bookCode") String bookCode){
		Optional<Object> book = service.findByBookCode(bookCode);
		if(book.isEmpty()) throw new BookNotFoundException("Livro não encontrado");
		return ResponseEntity.status(HttpStatus.OK).body(book.get());
	}
	

	@GetMapping("/find")
	public ResponseEntity<List<BookModel>> getBookByTitle(@RequestParam("title") String title){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByTitle(title));
	}

	@PostMapping("/")
	public ResponseEntity<List<BookModel>> saveBook(@RequestBody @Valid BookModelDto bookModelDto){
		return ResponseEntity.status(HttpStatus.OK).body(service.create (bookModelDto));
	}
	

	
}
