package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.BookAlreadyCheckedOutException;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.MaximumCheckoutLimitReachedException;

public interface BookCheckoutService {

    void checkoutBookForBorrower(Book book, Borrower borrower) throws BookAlreadyCheckedOutException, MaximumCheckoutLimitReachedException;

}
