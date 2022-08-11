package com.aredu.biblio.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookModelBuilderTest {

    @Test
    @DisplayName("Deve ser capaz de gerar um livro informando apenas o isbn")
    void shouldGenerateOneBookWithIsbnOnly(){

        List<BookModel> bookModelList = BookModelBuilder.builder("Isso é apenas um teste").addIsbn("0123456789").get();

        Assertions.assertEquals(1, bookModelList.size());
        Assertions.assertEquals(10, String.valueOf(bookModelList.get(0).getIsbn()).length());
        Assertions.assertEquals(11, String.valueOf(bookModelList.get(0).getBookCode()).length());
        Assertions.assertEquals("01234567891", bookModelList.get(0).getBookCode());
        
    }
    
        
    @Test
    @DisplayName("Deve ser capaz de gerar três livros informando apenas a quantidade")
    void shouldGenerateThreeBook(){


        List<BookModel> bookModelList = BookModelBuilder.builder("Isso é apenas um teste").addNumberOfCopies(3).get();

        Assertions.assertEquals(3, bookModelList.size());
        Assertions.assertEquals(11, bookModelList.get(0).getBookCode().length());
        Assertions.assertEquals(null, bookModelList.get(0).getIsbn());
        Assertions.assertNotEquals(bookModelList.get(0).getBookCode(), bookModelList.get(0).getIsbn());
    }
    
    
    @Test
    @DisplayName("Deve ser capaz de gerar três livros informando apenas a quantidade")
    void shouldGenerateThreeBookWithIsbnAndAmount(){


        List<BookModel> bookModelList = BookModelBuilder.builder("Isso é apenas um teste").addNumberOfCopies(3).addIsbn("0123456789").get();

        Assertions.assertEquals(3, bookModelList.size());
        Assertions.assertEquals(10, String.valueOf(bookModelList.get(0).getIsbn()).length());
        Assertions.assertEquals(11, String.valueOf(bookModelList.get(0).getBookCode()).length());
    }


    @Test
    @DisplayName("Deve ser capaz de lançar uma ILegalArgumentException por isbn inválido")
    void shouldThrowIllegalArgumentExceptionWithInvalidIsbn(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> BookModelBuilder.builder("Isso é apenas um teste").addIsbn("0123").get());
    }

    @Test
    @DisplayName("Deve ser capaz de lançar uma ILegalArgumentException por numero de copia inválido")
    void shouldThrowIllegalArgumentExceptionWithInvalidNumberOfCopies(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> BookModelBuilder.builder("Isso é apenas um teste").addNumberOfCopies(-1).get());
    }


}
