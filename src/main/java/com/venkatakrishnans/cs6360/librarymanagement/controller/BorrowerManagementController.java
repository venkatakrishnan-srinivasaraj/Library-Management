package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.SsnAlreadyExistsException;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/borrower")
public class BorrowerManagementController {

    @Autowired
    private BorrowerManagementService borrowerManagementService;

    @Autowired
    private BookLoanRepository bookLoanRepository;

    @RequestMapping("")
    @PostMapping
    public String createBorrower(@RequestBody Borrower borrower){
        try {
            borrowerManagementService.createBorrower(borrower);
        } catch (SsnAlreadyExistsException e) {
            e.printStackTrace();
            return "given ssn already exists";
        }
        return "success";
    }

}
