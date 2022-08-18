package com.aredu.biblio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aredu.biblio.dto.BookModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.respository.BookRepository;

import javax.transaction.Transactional;


@Service
public class BookService {

	@Autowired
	private BookRepository repository;


	@Transactional
	public List<BookModel> create (BookModelDto bookModelDto){
		return savedBooks(generateBooks(bookModelDto));
	}

	private List<BookModel> savedBooks (List<BookModel> books){
		List<BookModel> savedBooks = new ArrayList<BookModel>();
		for(BookModel book : books){
			savedBooks.add(repository.save(book));
		}
		return savedBooks;
	}

	private List<BookModel> generateBooks(BookModelDto bookModelDto){
		String isbn = bookModelDto.getIsbn();
		List<BookModel>books = findByIsbn(bookModelDto.getIsbn());
		int lastCopy = getLastCopyNumberOfBook(books);
		BookModel book = new BookModel.Builder()
				.addIsbn(bookModelDto.getIsbn())
				.addTitle(bookModelDto.getTitle())
				.addObs(bookModelDto.getObs())
				.addCopyNumber(lastCopy)
				.build();

		return buildNewBooks(book, bookModelDto.getNumberOfCopies());
	}

	private int getLastCopyNumberOfBook(List books){
		if(books.isEmpty()) return 0;
		BookModel book = (BookModel) books.get(books.size()-1);
		return book.getCopyNumber();
	}

	private List<BookModel> findByIsbn (String isbn){
		if(isbn.isEmpty()) return new ArrayList<BookModel>();
		return repository.findByIsbn(isbn);
	}

	public Optional<Object> findByBookCode(String bookCode){
		return repository.findByBookCode(bookCode);
	}

	private String getRandomId(){
		long getBaseNum = System.currentTimeMillis();
		return String.valueOf(getBaseNum);
	}

	private List<BookModel> buildNewBooks(BookModel bookModel, int numberOfCopies){
		List<BookModel> books = new ArrayList<>();
		int baseCopyNumber = bookModel.getCopyNumber();
		for (int x=1; x <= numberOfCopies; x++) {
			BookModel book = new BookModel.Builder()
					.addTitle(bookModel.getTitle())
					.addIsbn(bookModel.getIsbn())
					.addObs(bookModel.getObs())
					.addBookCode(getRandomId()+x)
					.build();


			book.setCopyNumber( baseCopyNumber + 1);
			books.add(book);
			baseCopyNumber++;
		}
		return books;
	}

	public List<BookModel> findByTitle(String title){
		return repository.findByTitleContains(title);
	}

}
