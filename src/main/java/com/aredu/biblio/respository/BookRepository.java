package com.aredu.biblio.respository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aredu.biblio.models.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

	
	
}
