package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.SsnAlreadyExistsException;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrower")
public class BorrowerManagementController {

    @Autowired
    private BorrowerManagementService borrowerManagementService;

    @Autowired
    private BookLoanRepository bookLoanRepository;

    @RequestMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public String createBorrower(@RequestBody Borrower borrower) {
        try {
            borrowerManagementService.createBorrower(borrower);
        } catch (SsnAlreadyExistsException e) {
            e.printStackTrace();
            return "given ssn already exists";
        }
        return "success";
    }

    @RequestMapping("/{borrowerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Borrower getBorrower(@PathVariable String borrowerId) {
        return borrowerManagementService.findByBorrowerId(borrowerId);
    }

}
