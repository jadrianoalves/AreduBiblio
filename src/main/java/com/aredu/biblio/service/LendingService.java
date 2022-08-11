package com.aredu.biblio.service;

import com.aredu.biblio.models.StudentModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LendingService {



    public List<StudentModel> findStudents(){

        RestTemplate restTemplate = new RestTemplate();

        String resource = "https://sisaredu.diganmedia.com.br/api/alunos-por-nome";

        ResponseEntity <List> response = restTemplate.getForEntity(resource, List.class);

        List<StudentModel> students = response.getBody();

        return students;
    }


}
