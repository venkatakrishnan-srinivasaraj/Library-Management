package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fine")
public class FineManagementController {

    @Autowired
    private FineManagementService fineManagementService;

    @Autowired
    private FineCalculatorService fineCalculatorService;

    @Autowired
    BorrowerService borrowerService;

    @RequestMapping("/refresh")
    public String recalculateTheFineForActiveBookLoans(){
       fineManagementService.calculateAndUpdateFineForAllBookLoans();
       return "success";
    }

    @RequestMapping("/borrower/{borrowerId}")
    public double getExistingActiveFinesForBorrower(@PathVariable String borrowerId){
        Borrower borrower = borrowerService.findBorrowerByBorrowerId(borrowerId);
        double payableFine = fineCalculatorService.calculatePayableFineAmountForABorrower(borrower);
        return payableFine;
    }

    @RequestMapping("/payment")
    public String makePayment(){
        //To-do implement make payment
        fineManagementService.calculateAndUpdateFineForAllBookLoans();
        return "success";
    }

}
