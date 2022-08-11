package com.aredu.biblio.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aredu.biblio.models.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

}
