package com.aredu.biblio.service;

import com.aredu.biblio.dto.LendingModelDto;
import com.aredu.biblio.erros.BookNotFoundException;
import com.aredu.biblio.models.BookModel;
import com.aredu.biblio.models.LendingModel;
import com.aredu.biblio.models.StatusLendingEnum;
import com.aredu.biblio.respository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
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
        return repository.findAllByBookCode(bookCode);
    }

    @Transactional
    public LendingModel create (LendingModelDto lendingModelDto){

        if(countByStudentLending(lendingModelDto.getStudent().getId()) > 5) throw new BookNotFoundException("Número de livros excedido");
       if(findBorrowedBooks(lendingModelDto.getBookCode(),StatusLendingEnum.LOANED ).size() > 0) throw new BookNotFoundException("Livro não disponível");


        LendingModel lending = new LendingModel.Builder()
                .addStudent(lendingModelDto.getStudent())
                .addBookCode(lendingModelDto.getBookCode())
                .addBook(lendingModelDto.getBookModel())
                .addDateOfLending(LocalDate.now())
                .addDateOfDevolution(LocalDate.now().plus(15,ChronoUnit.DAYS))
                .addStatus(StatusLendingEnum.LOANED)
                .build();

        return repository.save(lending);
    }


    public List<Object[]> findBorrowedBooks (String bookCode, StatusLendingEnum status){
        return repository.findBorrowedBooksByBookCode(bookCode, status);
    }


    public int countByStudentLending(long id){
        return repository.countByStudentLending(id);
    }





    public List<LendingModel> findAll(){
        return repository.findAll();
    }


//    public LendingModel returnBook (String bookCode){
//        List<Object[]> loan = repository.findBorrowedBooksByBookCode(bookCode, StatusLendingEnum.LOANED);
//
//
//        lending.setStatus(StatusLendingEnum.RETURNED);
//        return repository.save(lending);
//
//    }



}

