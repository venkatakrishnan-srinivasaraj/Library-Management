package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookCheckinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/book/checkin")
public class BookCheckinController {

    private final BookCheckinService bookCheckinService;

    private final BookLoanRepository bookLoanRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/search/{searchTerm}")
    public List<BookLoan> searchActiveBookLoans(@PathVariable String searchTerm){
       return bookCheckinService.searchCurrentlyActiveBookLoans(searchTerm);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/perform/{bookLoanId}")
    public String performCheckin(@PathVariable long bookLoanId){
        bookCheckinService.performCheckinOfBookLoan(bookLoanRepository.findByBookLoanId(bookLoanId));
        return "success";
    }
}
