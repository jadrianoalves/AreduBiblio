package com.aredu.biblio.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.aredu.biblio.dto.BookModelDto;
import com.aredu.biblio.respository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.respository.BookRepository;


@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	
	
	@InjectMocks
	private BookService bookService;
	
	
	@Mock
	private BookRepository bookRepository;
	@Mock
	private CategoryRepository categoryRepository;
	
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

		BookModel newBook = new BookModel(); newBook.setIsbn("123456789");
		newBook.setTitle("Isso é um teste");
		newBook.setCategory(new
				CategoryModel("teste"));

		CategoryModel newCaegory = new CategoryModel("teste");

		  BookModelDto book = new BookModelDto();
		  book.setTitle("Isso é mais um teste");
		  book.setIsbn("0123456789");
		  book.setNumberOfCopies(3);

		  when(bookRepository.save(any())).thenReturn(newBook);

		  when(categoryRepository.findById(any())).thenReturn(Optional.of(newCaegory));

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
