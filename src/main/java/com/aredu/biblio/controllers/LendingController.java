package com.aredu.biblio.controllers;

import com.aredu.biblio.dto.LendingModelDto;
import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StatusLendingEnum;

import com.aredu.biblio.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lending")
public class LendingController {

    @Autowired
    private LendingService service;

    public LendingController(LendingService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ResponseEntity <List<LendingModel>> getLending(){
             List<LendingModel> lending = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lending);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<Integer> countLending( @PathVariable(value = "id") long id){
        Integer count = service.countByStudentLending(id);
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @PostMapping("/")
    public ResponseEntity <LendingModel> create (@RequestBody @Valid LendingModelDto lendingModelDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(lendingModelDto));
    }

    @GetMapping("/return/{option}/{bookCode}")
    public ResponseEntity<List<Object[]>> findBorrowedBooks (@PathVariable(value = "option") String option, @PathVariable(value = "bookCode") String bookCode){
            List<Object[]> lending = service.findBorrowedBooks(bookCode, StatusLendingEnum.valueOf(option));
        return ResponseEntity.status(HttpStatus.OK).body(lending);
    }

//    @GetMapping("/return/{bookCode}")
//    public ResponseEntity<LendingModel> returnBook (@PathVariable(value = "bookCode") String bookCode){
//        return ResponseEntity.status(HttpStatus.OK).body(service.returnBook(bookCode));
//    }


}
