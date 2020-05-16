package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookCheckinService;
import com.venkatakrishnans.cs6360.librarymanagement.util.DateTimeUtility;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookCheckinServiceImpl implements BookCheckinService {

     private final BookLoanRepository bookLoanRepository;

     @Override
     public List<BookLoan> searchCurrentlyActiveBookLoans(String searchTerm) {
          List<BookLoan> currentlyActiveBookLoansFilteredBySearchTerm  = bookLoanRepository.findAllByReturnDateIsNullAndBorrowerBorrowerIdContainingOrBorrowerFirstNameContainingOrBorrowerLastNameContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(searchTerm,searchTerm,searchTerm,searchTerm,searchTerm);
          return currentlyActiveBookLoansFilteredBySearchTerm;
     }

     @Override
     public void performCheckinOfBookLoan(BookLoan bookLoan) {
          bookLoan.setReturnDate(DateTimeUtility.getCurrentDate());
          bookLoanRepository.save(bookLoan);
     }
}
