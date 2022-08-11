package com.aredu.biblio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.respository.BookRepository;



@Service
public class BookService {

	
	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
	}
	
	

	
	public BookModel save(BookModel bookModel) {
		return bookRepository.save(bookModel);
	}


	public Optional<BookModel> findById(Long id) {
		
		return bookRepository.findById(id);
				
				  
					
	}
	
	
	public List<Long> gerarIds(String inicial, int qtd){
		List<Long> lista = new ArrayList();
		for (int x=1; x <= qtd; x++ ) {
			String result = inicial.concat(String.valueOf(x));
			lista.add(Long.parseLong(result));
		}
		return lista;
	}
	

	
	
	
}
