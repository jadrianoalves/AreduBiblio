package com.aredu.biblio.respository;

import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    List<StudentModel> findByNameContains(String name);



}
