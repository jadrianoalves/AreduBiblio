package com.aredu.biblio.respository;

import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StatusLendingEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LendingRepository extends JpaRepository<LendingModel, Long> {

    List<LendingModel> findAllByBookCode(String bookCode);

    @Query("Select c.bookCode, c.book, c.student, c.dateOfLending, c.dateOfDevolution, c.status from LendingModel as c where c.bookCode = :bookCode and status = :status")
    List<Object[]> findBorrowedBooksByBookCode(String bookCode, StatusLendingEnum status);

}


