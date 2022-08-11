package com.aredu.biblio.service;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.respository.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public CategoryModel save (CategoryModel categoryModel) {
		return categoryRepository.save(categoryModel);
	}
	
	public Optional<CategoryModel> findById (Long category) {
		return categoryRepository.findById(category);
	}

	public List<CategoryModel> findAll() {
		return categoryRepository.findAll();
	}
	
	

}
