package com.aredu.biblio.models;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Teste da entidade Book")
public class BookModelTest {

    @Test
    void shouldCreateANewBook(){

        BookModel book = new BookModel.Builder()
                .addIsbn("0123456789")
                .addBookCode("01234567891")
                .addTitle("isso é apenas um teste de unidade")
                .addObs("aqui tem uma observação")
                .build();

        Assertions.assertThat(book.getId()).isGreaterThan(0);

    }

}
