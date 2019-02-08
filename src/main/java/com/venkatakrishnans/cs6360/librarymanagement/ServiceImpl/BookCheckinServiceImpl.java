package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookCheckinService;
import com.venkatakrishnans.cs6360.librarymanagement.Util.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCheckinServiceImpl implements BookCheckinService {

     @Autowired
     BookLoanRepository bookLoanRepository;

     @Override
     public List<BookLoan> searchCurrentlyActiveBookLoans(String searchTerm) {
          List<BookLoan> currentlyActiveBookLoansFilteredBySearchTerm  = bookLoanRepository.findAllByReturnDateIsNullAndBorrowerBorrowerIdContainingOrBorrowerFirstNameContainingOrBorrowerLastNameContainingOrBookIsbn10ContainingOrBookIsbn13Containing(searchTerm,searchTerm,searchTerm,searchTerm,searchTerm);
          return currentlyActiveBookLoansFilteredBySearchTerm;
     }

     @Override
     public void performCheckinOfBookLoan(BookLoan bookLoan) {
          bookLoan.setReturnDate(DateTimeUtility.getCurrentDate());
          bookLoanRepository.save(bookLoan);
     }
}
