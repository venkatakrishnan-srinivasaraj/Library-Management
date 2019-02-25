package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookCheckinService;
import com.venkatakrishnans.cs6360.librarymanagement.util.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCheckinServiceImpl implements BookCheckinService {

     @Autowired
     BookLoanRepository bookLoanRepository;

     @Override
     public List<BookLoan> searchCurrentlyActiveBookLoans(String searchTerm) {
//          String borrowerId = Long.parseLong(searchTerm);

          List<BookLoan> currentlyActiveBookLoansFilteredBySearchTerm  = bookLoanRepository.findAllByReturnDateIsNullAndBorrowerBorrowerIdContainingOrBorrowerFirstNameContainingOrBorrowerLastNameContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(searchTerm,searchTerm,searchTerm,searchTerm,searchTerm);
          return currentlyActiveBookLoansFilteredBySearchTerm;
     }

     @Override
     public void performCheckinOfBookLoan(BookLoan bookLoan) {
          bookLoan.setReturnDate(DateTimeUtility.getCurrentDate());
          bookLoanRepository.save(bookLoan);
     }
}
