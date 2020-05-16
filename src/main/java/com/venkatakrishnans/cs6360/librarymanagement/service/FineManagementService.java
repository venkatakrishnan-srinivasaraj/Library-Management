package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.dto.FineByBorrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.InvalidPaymentAmountException;

public interface FineManagementService {

    void calculateAndUpdateFineForAllBookLoans();
    FineByBorrower getFineByBorrower(String borrowerId);
    void payFinesForAllReturnedBooksByBorrower(String borrowerId);
    void makePaymentTowardsFine(Borrower borrower, Double amountPaid) throws InvalidPaymentAmountException;
}
