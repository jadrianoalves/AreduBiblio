package com.aredu.biblio.controllers;

import com.aredu.biblio.dto.BookModelDto;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;




@AutoConfigureMockMvc
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @MockBean
    private BookService service;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BookController controller;


    @Test
    @DisplayName("GET /books/{code}")
    void testFindBookWithCodeSuccess() throws Exception {

        BookModel book1 = new BookModel.Builder()
                .addTitle("isso é um teste")
                .build();

        doReturn(Optional.of(book1)).when(service).findByBookCode(any());

        mockMvc.perform(get("/books/01234567891"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("GET /books/find?=title=param")
    void shouldGetBookWithTitle() throws Exception{

        List<BookModel> books = new ArrayList<BookModel>();

        BookModel book1 = new BookModel.Builder()
                .addTitle("isso é um teste")
                .build();

        BookModel book2 = new BookModel.Builder()
                .addTitle("isso é um teste")
                .build();

        books.add(book1);
        books.add(book2);


        Mockito.when(service.findByTitle(any())).thenReturn(books);


        mockMvc.perform(get("/books/find?title=teste"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    @Test
    @DisplayName("GET /books/")
    void shouldCreateBookTitleOnly() throws Exception{


        BookModelDto dto = new BookModelDto("","Isso é um teste","",1);

        List<BookModel> books = new ArrayList<BookModel>();

        BookModel book1 = new BookModel.Builder()
                .addTitle("isso é um teste")
                .build();

        BookModel book2 = new BookModel.Builder()
                .addTitle("isso é um teste")
                .build();

        books.add(book1);
        books.add(book2);

        Mockito.when(service.create(dto)).thenReturn(books);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dto)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("GET /books/")
    void shouldCreateThreeBook(){


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
