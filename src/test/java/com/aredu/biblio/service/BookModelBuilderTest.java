package com.aredu.biblio.service;

import com.aredu.biblio.models.BookCode;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.CategoryModel;
import com.aredu.biblio.service.BookModelBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookModelBuilderTest {
    @Autowired
    BookService bookService;
    @Test
    @DisplayName("Deve ser capaz de gerar um livro informando apenas o isbn")
    void shouldGenerateOneBookWithIsbnOnly(){


        List<BookModel> bookModelList = BookModelBuilder.builder("Isso é apenas um teste", new BookCode("0123456789",1),new CategoryModel("Fixcão"))
                .addIsbn("0123456789")
                .get();

        Assertions.assertEquals(1, bookModelList.size());
        Assertions.assertEquals(10, String.valueOf(bookModelList.get(0).getIsbn()).length());
        Assertions.assertEquals(11, String.valueOf(bookModelList.get(0).getBookCode()).length());
        Assertions.assertEquals("01234567891", bookModelList.get(0).getBookCode());
        
    }
    
        
    @Test
    @DisplayName("Deve ser capaz de gerar três livros informando apenas a quantidade")
    void shouldGenerateThreeBook(){


        List<BookModel> bookModelList = BookModelBuilder.builder("Isso é apenas um teste", new BookCode("0123456789",1),new CategoryModel("Fixcão"))
                .addNumberOfCopies(3)
                .get();

        Assertions.assertEquals(3, bookModelList.size());
        Assertions.assertEquals(11, bookModelList.get(0).getBookCode().length());
        Assertions.assertEquals(null, bookModelList.get(0).getIsbn());
        Assertions.assertNotEquals(bookModelList.get(0).getBookCode(), bookModelList.get(0).getIsbn());
    }
    
    
    @Test
    @DisplayName("Deve ser capaz de gerar três livros informando apenas a quantidade")
    void shouldGenerateThreeBookWithIsbnAndAmount(){


        List<BookModel> bookModelList = BookModelBuilder.builder("Isso é apenas um teste", new BookCode("0123456789",1),new CategoryModel("Fixcão"))
                .addIsbn("0123456789")
                .addNumberOfCopies(3)
                .get();

        Assertions.assertEquals(3, bookModelList.size());
        Assertions.assertEquals(10, String.valueOf(bookModelList.get(0).getIsbn()).length());
        Assertions.assertEquals(11, String.valueOf(bookModelList.get(0).getBookCode()).length());
    }

}
