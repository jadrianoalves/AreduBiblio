package com.aredu.biblio.controllers;

import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.StudentModel;
import com.aredu.biblio.service.LendingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lending")
public class LendingController {


    private final LendingService lendingService;

    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }


    @GetMapping("/students")
    public ResponseEntity <List<StudentModel>> getStudents(){
             List<StudentModel> students = lendingService.findStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

}
