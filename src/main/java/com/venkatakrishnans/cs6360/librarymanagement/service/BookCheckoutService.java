package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.BookAlreadyCheckedOutException;
import com.venkatakrishnans.cs6360.librarymanagement.exception.MaximumCheckoutLimitReachedException;

public interface BookCheckoutService {

    void checkoutBookForBorrower(Book book, Borrower borrower) throws BookAlreadyCheckedOutException, MaximumCheckoutLimitReachedException;

}
