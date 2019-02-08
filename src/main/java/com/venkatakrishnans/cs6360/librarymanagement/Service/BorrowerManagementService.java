package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.SsnAlreadyExistsException;

public interface BorrowerManagementService {

    void createBorrower(Borrower borrower) throws SsnAlreadyExistsException;
}
