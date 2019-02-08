package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.InvalidPaymentAmountException;

public interface FineManagementService {

    void calculateAndUpdateFineForAllBookLoans();
    void makePaymentTowardsFine(Borrower borrower, Double amountPaid) throws InvalidPaymentAmountException;
}
