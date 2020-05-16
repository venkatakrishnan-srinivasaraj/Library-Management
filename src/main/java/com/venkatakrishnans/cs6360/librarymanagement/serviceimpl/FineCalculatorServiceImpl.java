package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Fine;
import com.venkatakrishnans.cs6360.librarymanagement.repository.FineRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.util.DateTimeUtility;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class FineCalculatorServiceImpl implements FineCalculatorService {

     //TO-DO change it to application property
     private static final double FINE_PER_DAY = 0.25;

     //TO-DO change it to application property
     private static final int DEFAULT_BOOK_BORROWING_PERIOD = 14;

     private final FineRepository fineRepository;

     @Override
     public double calculateFineForBookLoan(BookLoan bookLoan) {
          long durationInDaysOfBookBorrowed;
          if(bookLoan.getReturnDate()==null){
               durationInDaysOfBookBorrowed = DateTimeUtility.getDateDifferenceBetweenTwoDates(bookLoan.getCheckoutDate(), DateTimeUtility.getCurrentDate(), TimeUnit.DAYS);
               if(durationInDaysOfBookBorrowed>DEFAULT_BOOK_BORROWING_PERIOD){
                    double fine = durationInDaysOfBookBorrowed * FINE_PER_DAY;
                    return fine;
               }
          }else{
               durationInDaysOfBookBorrowed = DateTimeUtility.getDateDifferenceBetweenTwoDates(bookLoan.getReturnDate(), bookLoan.getCheckoutDate(), TimeUnit.DAYS);
               if(durationInDaysOfBookBorrowed>DEFAULT_BOOK_BORROWING_PERIOD){
                    double fine = durationInDaysOfBookBorrowed * FINE_PER_DAY;
                    return fine;
               }
          }
          return 0;
     }

     @Override
     public double calculateExistingFineAmountForABorrower(Borrower borrower) {
          List<Fine> listOfUnpaidFinesByBorrower = fineRepository.findAllByBookLoan_BorrowerAndPaidStatusIsFalse(borrower);
          double totalUnpaidLoanAmount = listOfUnpaidFinesByBorrower.stream().mapToDouble(each->each.getFineAmount()).sum();
          return totalUnpaidLoanAmount;
     }

     @Override
     public double calculatePayableFineAmountForABorrower(Borrower borrower) {
          List<Fine> listOfPayableFinesByBorrower = fineRepository.findAllByBookLoan_Borrower_BorrowerIdAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(borrower.getBorrowerId());
          double totalPayableLoanAmount = listOfPayableFinesByBorrower.stream().mapToDouble(each->each.getFineAmount()).sum();
          return totalPayableLoanAmount;
     }
}
