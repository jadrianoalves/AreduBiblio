package com.aredu.biblio.controllers;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class BookControllerTest {

    @MockBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookController bookCOntroller;


    @Test
    @DisplayName("GET /books/id")
    void testFindBookSuccess() throws Exception {

        BookModel book1 = new BookModel.Builder()
                .addTitle("isso é um teste")
                .build();

        doReturn(Optional.of(book1)).when(bookService).findByBookCode("01234567891");

        mockMvc.perform(get("/books/01234567891"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("GET /books/categories")
    void shouldGetBookWithCode() throws Exception{



    }




    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
