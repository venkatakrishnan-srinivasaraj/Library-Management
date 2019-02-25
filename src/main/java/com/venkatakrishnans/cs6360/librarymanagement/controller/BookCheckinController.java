package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookCheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book/checkin")
public class BookCheckinController {

    @Autowired
    private BookCheckinService bookCheckinService;

    @Autowired
    private BookLoanRepository bookLoanRepository;

    @RequestMapping("/search/{searchTerm}")
    public List<BookLoan> searchActiveBookLoans(@PathVariable String searchTerm){
       return bookCheckinService.searchCurrentlyActiveBookLoans(searchTerm);
    }

    @RequestMapping("/perform/{bookLoanId}")
    public String performCheckin(@PathVariable long bookLoanId){
        bookCheckinService.performCheckinOfBookLoan(bookLoanRepository.findByBookLoanId(bookLoanId));
        return "success";
    }
}
