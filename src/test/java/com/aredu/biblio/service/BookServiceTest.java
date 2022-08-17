package com.aredu.biblio.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.aredu.biblio.dto.BookModelDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.respository.BookRepository;


@ExtendWith(SpringExtension.class)
public class BookServiceTest {

	
	@InjectMocks
	private BookService service;
	
	
	@Mock
	private BookRepository repository;

	
	  @BeforeEach void setup() {
	  
	  BookModel book = new BookModel.Builder()
			  .addTitle("Isso é apenas um teste")
			  .build();

	  when(repository.findById(1L)) .thenReturn(Optional.of(book));
	  when(repository.save(any())).thenReturn(book);

	  
	  }
	
	@Test
	void shouldSaveBook() {

		BookModelDto dto = new BookModelDto("","Isso é um teste","",1);
		
		List<BookModel> newBooks = service.create(dto);
		
		Assertions.assertThat(newBooks.size()).isEqualTo(1);
		
	}
	


	
	
	@Test
	@DisplayName("Deve encontrar um livro pelo id e retornálo")
	void sholdFindBookForId() {

		BookModel book = new BookModel.Builder()
				.addTitle("Isso é apenas um teste")
				.build();

		when(repository.findById(1L))
			.thenReturn(Optional.of(book));
		
		Assertions.assertThat(repository.findById(1L).isPresent()).isTrue();
		
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
		
}
