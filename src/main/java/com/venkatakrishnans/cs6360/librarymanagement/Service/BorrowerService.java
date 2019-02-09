package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;

public interface BorrowerService {

     Borrower findBorrowerByBorrowerId(String borrowerId);
}
