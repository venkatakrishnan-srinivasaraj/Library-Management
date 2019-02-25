package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;

import java.util.List;

public interface BookCheckinService {

    List<BookLoan> searchCurrentlyActiveBookLoans(String searchTerm);

    void performCheckinOfBookLoan(BookLoan bookLoan);

}
