package com.aredu.biblio.respository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aredu.biblio.models.BookModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {


    Optional<Object> findByBookCode(String bookCode);

    List<BookModel> findByIsbn(String isbn);

}
