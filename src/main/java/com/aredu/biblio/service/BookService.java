package com.aredu.biblio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aredu.biblio.dto.BookModelDto;
import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookCode;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.respository.CategoryRepository;
import org.springframework.stereotype.Service;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.respository.BookRepository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;


@Service
public class BookService {

	
	private BookRepository bookRepository;
	private CategoryRepository categoryRepository;


	public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {

        this.bookRepository = bookRepository;
		this.categoryRepository = categoryRepository;
	}

	@Transactional
	public List<BookModel> create (BookModelDto bookModelDto){

		BookCode bookCode = bookCodeFactory(bookModelDto.getIsbn());

		CategoryModel category = findCategory(bookModelDto.getCategoryId());

		List<BookModel> books = BookModelBuilder
				.builder(bookModelDto.getTitle(),bookCode, category)
				.addIsbn(bookModelDto.getIsbn())
				.addNumberOfCopies(bookModelDto.getNumberOfCopies())
				.get();
		List<BookModel> generatedBooks = new ArrayList<BookModel>();
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

	public Optional<Object> findByBookCode(String bookCode) {
		return bookRepository.findByBookCode(bookCode);
	}

	public BookCode bookCodeFactory(String isbn){
		int lastNumberOfCopy;
		 lastNumberOfCopy =  getLastNumberOfCopy(isbn);
			if(lastNumberOfCopy == 0) return new BookCode(getRandomId(), 1);
		return new BookCode(isbn, lastNumberOfCopy + 1);
	}

	private String getRandomId(){

		long getBaseNum = System.currentTimeMillis();
		return String.valueOf(getBaseNum).substring(3,13);

	}


	public int getLastNumberOfCopy(String isbn){
		List<BookModel>books;
		 books = findByIsbn(isbn);
			if(books.isEmpty()) return 0;
		return findByIsbn(isbn).get(books.size()-1).getNumberOfCopy();
	}

	public List<BookModel> findByIsbn(String isbn){
		return bookRepository.findByIsbn(isbn);
	}

	public CategoryModel findCategory(long id){
			Optional<CategoryModel> category = categoryRepository.findById(id);
			if(category.isEmpty()) throw new BookNotFoundException("Categoria de Livro não encontrada");
		return category.get();
	}

	public List<BookModel> findByTitle(String title){
		return bookRepository.findByTitleContains(title);
	}

}
