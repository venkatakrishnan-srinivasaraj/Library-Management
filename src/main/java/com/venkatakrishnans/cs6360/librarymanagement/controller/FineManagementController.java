package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.dto.FineByBorrower;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineManagementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fine")
@AllArgsConstructor
public class FineManagementController {

    private final FineManagementService fineManagementService;

    private final FineCalculatorService fineCalculatorService;

    private final BorrowerService borrowerService;

    @RequestMapping("/refresh")
    public String recalculateTheFineForActiveBookLoans(){
       fineManagementService.calculateAndUpdateFineForAllBookLoans();
       return "success";
    }

//    @Deprecated
//    @RequestMapping("/borrower/{borrowerId}")
//    public double getExistingActiveFinesForBorrower(@PathVariable String borrowerId){
//        To-do
//        Borrower borrower = borrowerService.findBorrowerByBorrowerId(borrowerId);
//        double payableFine = fineCalculatorService.calculatePayableFineAmountForABorrower(borrower);
//        return payableFine;
//    }

    @RequestMapping("/borrower/{borrowerId}")
    public FineByBorrower getActiveFinesForBorrower(@PathVariable String borrowerId){
        return fineManagementService.getFineByBorrower(borrowerId);
    }

//    @RequestMapping("/payment/fine/{fineId}")
//    public String makePaymentByFineId(){
//        //To-do implement make payment
//        fineManagementService.calculateAndUpdateFineForAllBookLoans();
//        return "success";
//    }

    @RequestMapping("/payment/borrower/{borrowerId}")
    public String makePaymentByBorrowerId(@PathVariable String borrowerId){
        fineManagementService.payFinesForAllReturnedBooksByBorrower(borrowerId);
        return "success";
    }

}
