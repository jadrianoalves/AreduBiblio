package com.aredu.biblio.respository;

import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StatusLendingEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LendingRepository extends JpaRepository<LendingModel, Long> {

    List<LendingModel> findAllByBookCode(String bookCode);


    List<LendingModel> findByBookCodeAndStatus(String bookCode, StatusLendingEnum status);



    @Query("Select count(c) from LendingModel as c where c.student.id = :id and c.status = 1")
    Integer countByStudentLending (long id);


    @Query(value = "Select u from LendingModel as u where u.student.id = :id and u.dateOfDevolution < :date and u.status = 1")
    List<LendingModel> findLateReturnBook (Long id, LocalDate date);

    @Query(value = "select u from LendingModel as u where u.bookCode = :bookCode and u.status = 1")
    LendingModel findLendBook (String bookCode);

}


