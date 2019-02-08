package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookLoan;

import java.util.List;

public interface BookCheckinService {

    List<BookLoan> searchCurrentlyActiveBookLoans(String searchTerm);

    void performCheckinOfBookLoan(BookLoan bookLoan);

}
