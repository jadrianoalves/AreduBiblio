package com.aredu.biblio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aredu.biblio.dto.BookModelDto;
import com.aredu.biblio.models.BookModelBuilder;
import org.springframework.stereotype.Service;

import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.respository.BookRepository;

import javax.transaction.Transactional;


@Service
public class BookService {

	
	private BookRepository bookRepository;


	public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

	}

	@Transactional
	public List<BookModel> create (BookModelDto bookModelDto){
		List<BookModel> books = BookModelBuilder
				.builder(bookModelDto.getTitle())
				.addIsbn(bookModelDto.getIsbn())
				.addNumberOfCopies(bookModelDto.getAmount())
				.get();
		List<BookModel> generatedBooks = new ArrayList<>();
		books.stream().forEach(
				(book)-> generatedBooks.add(bookRepository.save(book))
		);
		return generatedBooks;
	}


	public BookModel save(BookModel bookModel) {
		return bookRepository.save(bookModel);
	}


	public Optional<BookModel> findById(Long id) {
		
		return bookRepository.findById(id);
				
				  
					
	}
	
	

	

	
	
	
}
