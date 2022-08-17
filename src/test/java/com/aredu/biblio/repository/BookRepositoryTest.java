package com.aredu.biblio.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.respository.BookRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
@DisplayName("teste do repositório")
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;



	@Autowired
	private TestEntityManager testEntityManager;
	

	


}
