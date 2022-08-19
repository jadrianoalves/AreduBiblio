package com.aredu.biblio.controllers;

import com.aredu.biblio.dto.LendingModelDto;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StudentModel;

import com.aredu.biblio.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lending")
public class LendingController {

    @Autowired
    private LendingService service;


    @GetMapping("/")
    public ResponseEntity <List<LendingModel>> getLending(){
             List<LendingModel> lending = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lending);
    }

    @PostMapping("/")
    public ResponseEntity <LendingModel> create (@RequestBody @Valid LendingModelDto lendingModelDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(lendingModelDto));
    }

    @GetMapping("/return/{book}")
    public ResponseEntity<LendingModel> returnBook (@PathVariable(value = "book") String bookCode){
        return ResponseEntity.status(HttpStatus.OK).body(service.returnBook(bookCode, "BORROWED"));
    }

}
