package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Fine;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.InvalidPaymentAmountException;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.FineRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.Service.FineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineManagementServiceImpl implements FineManagementService {

    @Autowired
    FineCalculatorService fineCalculatorService;

    @Autowired
    FineRepository fineRepository;

    @Autowired
    BookLoanRepository bookLoanRepository;

    @Override
    public void calculateAndUpdateFineForAllBookLoans() {
        List<BookLoan> listOfActiveBookLoans = bookLoanRepository.findAllByReturnDateIsNull();
        List<Fine> listOfExistingFines = fineRepository.findAllByBookLoanIn(listOfActiveBookLoans);

        listOfExistingFines.stream().forEach(each->{
            each.setFineAmount(fineCalculatorService.calculateFineForBookLoan(each.getBookLoan()));
        });

        listOfActiveBookLoans.removeAll(listOfExistingFines
                                        .stream()
                                        .map(each -> each.getBookLoan())
                                        .collect(Collectors.toList()));

        List<Fine> listOfNewFines = new ArrayList<>();
        listOfActiveBookLoans.stream().forEach(each->{
            Fine fine = Fine.builder()
                        .bookLoan(each)
                        .fineAmount(fineCalculatorService.calculateFineForBookLoan(each))
                        .paidStatus(false)
                        .build();
            listOfNewFines.add(fine);
        });

        fineRepository.saveAll(listOfExistingFines);
        fineRepository.saveAll(listOfNewFines);
    }

    private void makePaymentTowardsFine(Fine fine,Double amountPaid) throws InvalidPaymentAmountException {
        if(amountPaid<0){
            throw new InvalidPaymentAmountException();
        }
        if(fine.getFineAmount()>=amountPaid){
            fine.setPaidStatus(true);
        }else{
            fine.setFineAmount(fine.getFineAmount() - amountPaid);
        }
        fineRepository.save(fine);
    }

    @Override
    public void makePaymentTowardsFine(Borrower borrower, Double amountPaid) throws InvalidPaymentAmountException {
        if(amountPaid<0){
            throw new InvalidPaymentAmountException();
        }
        List<Fine> listOfUnpaidFinesByBorrowerForReturnedBooks = fineRepository.findAllByBookLoan_BorrowerAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(borrower);

        listOfUnpaidFinesByBorrowerForReturnedBooks.stream().sorted((each1,each2)->{
            if(each1.getFineAmount() < each2.getFineAmount()){
                return -1;
            }
            if(each1.getFineAmount() > each2.getFineAmount()){
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        double amountRemaining = amountPaid;
        for (Fine each : listOfUnpaidFinesByBorrowerForReturnedBooks) {
            if (amountRemaining < 0) {
                break;
            }
            makePaymentTowardsFine(each, amountRemaining);
            amountRemaining = amountRemaining - each.getFineAmount();
        }
    }
}
