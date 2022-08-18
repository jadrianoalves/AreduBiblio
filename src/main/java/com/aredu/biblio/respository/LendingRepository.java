package com.aredu.biblio.respository;

import com.aredu.biblio.models.LendingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LendingRepository extends JpaRepository<LendingModel, Long> {

    List<LendingModel> findByBookCode(String bookCode);

}


