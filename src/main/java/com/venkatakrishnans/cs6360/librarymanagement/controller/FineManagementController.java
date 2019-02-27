package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.domain.FineByBorrower;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/refresh")
    public String recalculateTheFineForActiveBookLoans(){
       fineManagementService.calculateAndUpdateFineForAllBookLoans();
       return "success";
    }

//    @Deprecated
//    @CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping("/borrower/{borrowerId}")
//    public double getExistingActiveFinesForBorrower(@PathVariable String borrowerId){
//        Borrower borrower = borrowerService.findBorrowerByBorrowerId(borrowerId);
//        double payableFine = fineCalculatorService.calculatePayableFineAmountForABorrower(borrower);
//        return payableFine;
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/borrower/{borrowerId}")
    public FineByBorrower getActiveFinesForBorrower(@PathVariable String borrowerId){
        return fineManagementService.getFineByBorrower(borrowerId);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
//    @RequestMapping("/payment/fine/{fineId}")
//    public String makePaymentByFineId(){
//        //To-do implement make payment
//        fineManagementService.calculateAndUpdateFineForAllBookLoans();
//        return "success";
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/payment/borrower/{borrowerId}")
    public String makePaymentByBorrowerId(@PathVariable String borrowerId){
        fineManagementService.payFinesForAllReturnedBooksByBorrower(borrowerId);
        return "success";
    }

}
