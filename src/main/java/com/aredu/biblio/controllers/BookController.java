package com.aredu.biblio.controllers;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import javax.validation.Valid;

import com.aredu.biblio.dto.BookModelEntry;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aredu.biblio.dto.BookModelDto;
import com.aredu.biblio.dto.CategoryModelDto;
import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.service.BookService;
import com.aredu.biblio.service.CategoryService;


@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;
	private final CategoryService categoryService;
	
	
	public BookController(BookService bookService, CategoryService categoryService) {
		this.bookService = bookService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookModel> getBook(@PathVariable(value ="id") Long id){
		BookModel book = bookService.findById(id).orElseThrow(()-> new BookNotFoundException("não encontrado"));

		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
		
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryModel>> getAllCategories(){
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
	}
	
	
	@GetMapping("/category/{id}")
	public ResponseEntity<Object> getCategory(@PathVariable(value = "id") Long id) {
		Optional<CategoryModel> OptinalCategoryModel = categoryService.findById(id);
//		if(!category.isPresent()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
//		}
		return ResponseEntity.status(HttpStatus.OK).body(OptinalCategoryModel.get());
	}	
	
	@PostMapping("/")
	public ResponseEntity<Object> saveBook(@RequestBody @Valid BookModelEntry bookModelEntry){
		var bookModel = new BookModel();
		BookModelDto bookModelDto = new BookModelDto();

		CategoryModel categoryModel = categoryService.findById(bookModelEntry.getCategory()).get();
		bookModelDto.setCategory(categoryModel);

		bookService.create (bookModelDto);

		

		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookModel));
	}
	
	
	
	@PostMapping("/categories")
	public ResponseEntity<Object> saveCategory(@RequestBody @Valid CategoryModelDto categoryModelDto){
		var categoryModel = new CategoryModel();
		BeanUtils.copyProperties(categoryModelDto, categoryModel);	
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryModel));
	}
	
	
	
}