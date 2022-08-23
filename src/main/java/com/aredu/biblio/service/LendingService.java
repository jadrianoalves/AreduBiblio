package com.aredu.biblio.service;

import com.aredu.biblio.dto.LendingModelDto;
import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StatusLendingEnum;
import com.aredu.biblio.respository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class LendingService {

    @Autowired
    private LendingRepository repository;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    public List<LendingModel> findByBookCode(String bookCode){
        return repository.findAllByBookCode(bookCode);
    }


    public LendingModel create (LendingModelDto lendingModelDto){

        LendingModel lending = new LendingModel.Builder()
                .addStudent(lendingModelDto.getStudent())
                .addBookCode(lendingModelDto.getBookCode())
                .addBook(lendingModelDto.getBookModel())
                .addDateOfLending(LocalDate.now())
                .addDateOfDevolution(LocalDate.now().plus(15,ChronoUnit.DAYS))
                .addStatus(StatusLendingEnum.BORROWED)
                .build();

        return repository.save(lending);
    }


    public List<Object[]> findBorrowedBooks (String bookCode, StatusLendingEnum status){
        return repository.findBorrowedBooksByBookCode(bookCode, status);
    }





    public List<LendingModel> findAll(){
        return repository.findAll();
    }



}

