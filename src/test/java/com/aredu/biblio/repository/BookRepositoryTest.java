package com.aredu.biblio.repository;

import com.aredu.biblio.respository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.respository.BookRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
@DisplayName("teste do repositório")
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	@DisplayName("save book when successful")
	void save_book_when_successful() {
		CategoryModel categoryModel = new CategoryModel("Teste");
		testEntityManager.persist(categoryModel);
		CategoryModel category = categoryRepository.findAll().get(0);
		BookModel book1 = new BookModel("0123456789","01234567891",1,"isso é um teste","",category);

		testEntityManager.persist(book1);

		Optional<Object> optionalOfBook = bookRepository.findByBookCode("01234567891");
		BookModel book = (BookModel)optionalOfBook.get();

		Assertions.assertThat(optionalOfBook).isPresent();
		Assertions.assertThat(book.getBookCode()).isEqualTo("01234567891");
	}
	


}
