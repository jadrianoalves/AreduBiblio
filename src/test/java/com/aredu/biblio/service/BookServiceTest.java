package com.aredu.biblio.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.aredu.biblio.dto.BookModelDto;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.respository.BookRepository;


@SpringBootTest
public class BookServiceTest {

	
	
	@InjectMocks
	private BookService bookService;
	
	
	@Mock
	private BookRepository bookRepository;
	
	  @BeforeEach void setup() {
	  
	  BookModel book = new BookModel(); book.setIsbn("123456789");
	  book.setTitle("Isso é um teste"); book.setCategory(new
	  CategoryModel("teste"));
	  
	  
	  when(bookRepository.findById(1L)) .thenReturn(Optional.of(book));
	  
	  
	  }
	
	@Test
	void shouldSaveBook() {
		
		BookModel book = new BookModel(); book.setIsbn("123456789");
		book.setTitle("Isso é um teste"); book.setCategory(new
		CategoryModel("teste"));
		
		when(bookRepository.save(book)).thenReturn(book);
		
		BookModel newBook = bookService.save(book);
		
		assertEquals(book, newBook);
		
	}
	
	@Test
	void shouldCreateBooks(){

		BookModel NewBook = new BookModel(); NewBook.setIsbn("123456789");
		NewBook.setTitle("Isso é um teste"); NewBook.setCategory(new
				CategoryModel("teste"));


		  BookModelDto book = new BookModelDto();
		  book.setTitle("Isso é mais um teste");
		  book.setIsbn("0123456789");
		  book.setCategory(1L);
		  book.setAmount(3);

		  when(bookRepository.save(any())).thenReturn(NewBook);

		  List<BookModel> books = bookService.create(book);

		  assertEquals(3, books.size());

	}

	
	
	@Test
	@DisplayName("Deve encontrar um livro pelo id e retornálo")
	void sholdFindBookForId() {


		BookModel book = new BookModel();
		book.setIsbn("123456789");
		book.setTitle("Isso é um teste");
		book.setCategory(new CategoryModel("teste"));
			
		
		when(bookRepository.findById(1L))
			.thenReturn(Optional.of(book));
		
		
		assertEquals("123456789", (bookRepository.findById(1L).get().getIsbn()));
		
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
		
}
