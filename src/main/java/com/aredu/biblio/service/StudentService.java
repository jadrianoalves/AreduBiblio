package com.aredu.biblio.service;

import com.aredu.biblio.dto.StudentModelDto;
import com.aredu.biblio.models.StudentModel;
import com.aredu.biblio.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    private StudentRepository repository;

    public List<StudentModel> findStudents(){

        RestTemplate restTemplate = new RestTemplate();
        String resource = "https://sisaredu.diganmedia.com.br/api/alunos-por-nome";
        ResponseEntity<List> response = restTemplate.getForEntity(resource, List.class);
        List<StudentModel> students = response.getBody();

        return students;
    }


    public StudentModel save(StudentModelDto studentModelDto){
        StudentModel studentModel = new StudentModel(studentModelDto.getId(), studentModelDto.getName(), studentModelDto.getEnrollmentId(), studentModelDto.getClassroom());
        studentModel.setActive(true);
        return repository.save(studentModel);
    }

    public StudentModel save(StudentModel studentModel){
        studentModel.setActive(true);
        return repository.save(studentModel);
    }

    public List<StudentModel> findByName(String name){
        return repository.findByNameContains(name);
    }

    public Optional<StudentModel> findById(long id){
        return repository.findById(id);
    }

    public StudentModel findOrSave(StudentModel studentModel){

        Optional<StudentModel> student = repository.findById(studentModel.getId());
          if(student.isEmpty()) return repository.save(studentModel); else return student.get();
    }



}
