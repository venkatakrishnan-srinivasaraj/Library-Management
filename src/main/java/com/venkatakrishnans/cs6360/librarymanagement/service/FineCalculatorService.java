package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;

public interface FineCalculatorService {

    double calculateFineForBookLoan(BookLoan bookLoan);

    double calculateExistingFineAmountForABorrower(Borrower borrower);

    double calculatePayableFineAmountForABorrower(Borrower borrower);

}
