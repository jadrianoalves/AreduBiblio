package com.aredu.biblio.service;

import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StudentModel;
import com.aredu.biblio.respository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class LendingService {


    @Autowired
    private LendingRepository lendingRepository;




}
