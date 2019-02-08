package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;

public interface FineCalculatorService {

    double calculateFineForBookLoan(BookLoan bookLoan);

    double calculateExistingFineAmountForABorrower(Borrower borrower);

    double calculatePayableFineAmountForABorrower(Borrower borrower);

}
