package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.SsnAlreadyExistsException;

public interface BorrowerManagementService {

    void createBorrower(Borrower borrower) throws SsnAlreadyExistsException;

    Borrower findByBorrowerId(String borrowerId);
}
