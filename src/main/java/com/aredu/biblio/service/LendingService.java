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

        Optional<Object> optionalBook = bookService.findByBookCode(lendingModelDto.getBookCode());
            if(optionalBook.isEmpty()) throw new BookNotFoundException("Livro não encontrado");
            BookModel book = (BookModel) optionalBook.get();
        StudentModel student = studentService.findOrSave(lendingModelDto.getStudent());
            LendingModel lending = lendBook(book, student);
            book.updateStatus(false);
            bookService.updateStatusBoook(book);
            return lending;

    }

    public LendingModel lendBook(BookModel book, StudentModel student){
        LendingModel lending = new LendingModel.Builder()
                .addDateOfLending(LocalDate.now())
                .addDateOfDevolution(LocalDate.now().plus(15,ChronoUnit.DAYS))
                .addBookCode(book.getBookCode())
                .addStudent(student)
                .addStatus(StatusLendingEnum.NOT_AVALIABLE)
                .build();
        return lending;
    }

    public List<LendingModel> getBorrowedBooks(long student){
        return studentService.findById(student).get().getLendingModelList();
    }

    public List<LendingModel> findAll(){
        return repository.findAll();
    }



}

