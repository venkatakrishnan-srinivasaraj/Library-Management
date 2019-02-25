package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;

public interface BorrowerService {

     Borrower findBorrowerByBorrowerId(String borrowerId);
}
