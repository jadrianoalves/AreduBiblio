package com.aredu.biblio.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.respository.BookRepository;

@DataJpaTest
@DisplayName("teste do repositório")
public class BookRepositoryTest {
	
	private final BookRepository bookRepository;
	
	public BookRepositoryTest(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	@Test
	@DisplayName("save book when successful")
	void save_book_when_successful() {
		
	}
	


}
