package com.aredu.biblio.service;

import com.aredu.biblio.dto.LendingModelDto;
import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StatusLendingEnum;
import com.aredu.biblio.models.StudentModel;
import com.aredu.biblio.respository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


@Service
public class LendingService {

    @Autowired
    private LendingRepository repository;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    public List<LendingModel> findByBookCode(String bookCode){
        return repository.findByBookCode(bookCode);
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

    public LendingModel returnBook(String bookCode, String status){
        return repository.findBorrowedBookByCode(bookCode, status);
    }





    public List<LendingModel> findAll(){
        return repository.findAll();
    }



}

