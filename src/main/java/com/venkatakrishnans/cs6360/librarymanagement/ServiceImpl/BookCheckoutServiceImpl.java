package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.*;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.BookAlreadyCheckedOutException;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.MaximumCheckoutLimitReachedException;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookAuthorMapRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookCheckoutService;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookSearchService;
import com.venkatakrishnans.cs6360.librarymanagement.Util.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCheckoutServiceImpl implements BookCheckoutService {

     //TO-DO change it to application property
     private static final int DEFAULT_BOOK_BORROWING_PERIOD = 14;

     @Autowired
     BookLoanRepository bookLoanRepository;

     @Override
     public void checkoutBookForBorrower(Book book, Borrower borrower) throws BookAlreadyCheckedOutException, MaximumCheckoutLimitReachedException {
          checkIfBookIsAvailableForCheckout(book);
          checkIfBorrowerIsEligibleForCheckout(borrower);
          performCheckout(book,borrower);
     }

     private void performCheckout(Book book, Borrower borrower) {
          BookLoan bookLoan = BookLoan.builder().book(book)
                              .borrower(borrower)
                              .checkoutDate(DateTimeUtility.getCurrentDate())
                              .dueDate((getDueDate()))
                              .returnDate(null)
                              .build();
          bookLoanRepository.save(bookLoan);
     }

     private Date getDueDate() {
          return DateTimeUtility.incrementDateBy(DateTimeUtility.getCurrentDate(),DEFAULT_BOOK_BORROWING_PERIOD);
     }


     private void checkIfBorrowerIsEligibleForCheckout(Borrower borrower) throws MaximumCheckoutLimitReachedException {
          long checkedOutBookCountForBorrower = bookLoanRepository.countAllByBorrowerAndReturnDateIsNull(borrower);
          if(checkedOutBookCountForBorrower>=3){
               throw new MaximumCheckoutLimitReachedException();
          }
     }

     private void checkIfBookIsAvailableForCheckout(Book book) throws BookAlreadyCheckedOutException {
         long checkedOutBookCount = bookLoanRepository.countAllByBookAndReturnDateIsNull(book);
         if(checkedOutBookCount>0){
              throw new BookAlreadyCheckedOutException();
         }
     }
}
