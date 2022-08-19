package com.aredu.biblio.controllers;


import com.aredu.biblio.dto.LendingModelDto;
import com.aredu.biblio.dto.StudentModelDto;
import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StudentModel;
import com.aredu.biblio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/")
    public ResponseEntity<StudentModel> create (@RequestBody @Valid StudentModelDto studentModelDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(studentModelDto));
    }

}
