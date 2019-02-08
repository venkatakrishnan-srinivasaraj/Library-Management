package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Fine;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.FineRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.Util.DateTimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FineCalculatorServiceImpl implements FineCalculatorService {

     //TO-DO change it to application property
     private static final double FINE_PER_DAY = 0.25;

     //TO-DO change it to application property
     private static final int DEFAULT_BOOK_BORROWING_PERIOD = 14;

     @Autowired
     FineRepository fineRepository;

     @Override
     public double calculateFineForBookLoan(BookLoan bookLoan) {
          if(bookLoan.getReturnDate()==null){
               long durationInDaysOfBookBorrowed = DateTimeUtility.getDateDifferenceBetweenTwoDates(DateTimeUtility.getCurrentDate(),bookLoan.getCheckoutDate(), TimeUnit.DAYS);
               if(durationInDaysOfBookBorrowed>DEFAULT_BOOK_BORROWING_PERIOD){
                    double fine = durationInDaysOfBookBorrowed * FINE_PER_DAY;
               }
               return 0;
          }else{
               long durationInDaysOfBookBorrowed = DateTimeUtility.getDateDifferenceBetweenTwoDates(bookLoan.getReturnDate(),bookLoan.getCheckoutDate(), TimeUnit.DAYS);
               if(durationInDaysOfBookBorrowed>DEFAULT_BOOK_BORROWING_PERIOD){
                    double fine = durationInDaysOfBookBorrowed * FINE_PER_DAY;
               }
               return 0;
          }
     }

     @Override
     public double calculateExistingFineAmountForABorrower(Borrower borrower) {
          List<Fine> listOfUnpaidFinesByBorrower = fineRepository.findAllByBookLoan_BorrowerAndPaidStatusIsFalse(borrower);
          double totalUnpaidLoanAmount = listOfUnpaidFinesByBorrower.stream().mapToDouble(each->each.getFineAmount()).sum();
          return totalUnpaidLoanAmount;
     }

     @Override
     public double calculatePayableFineAmountForABorrower(Borrower borrower) {
          List<Fine> listOfPayableFinesByBorrower = fineRepository.findAllByBookLoan_BorrowerAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(borrower);
          double totalPayableLoanAmount = listOfPayableFinesByBorrower.stream().mapToDouble(each->each.getFineAmount()).sum();
          return totalPayableLoanAmount;
     }
}
