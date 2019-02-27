package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.*;
import com.venkatakrishnans.cs6360.librarymanagement.exception.InvalidPaymentAmountException;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.repository.FineRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineCalculatorService;
import com.venkatakrishnans.cs6360.librarymanagement.service.FineManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FineManagementServiceImpl implements FineManagementService {

    @Autowired
    FineCalculatorService fineCalculatorService;

    @Autowired
    FineRepository fineRepository;

    @Autowired
    BorrowerService borrowerService;

    @Autowired
    BookLoanRepository bookLoanRepository;

    @Override
    public void calculateAndUpdateFineForAllBookLoans() {
        List<BookLoan> listOfActiveBookLoans = bookLoanRepository.findAllByReturnDateIsNull();
        List<Fine> listOfExistingFines = fineRepository.findAllByBookLoan_BookLoanIdIn(listOfActiveBookLoans.stream().map(each->each.getBookLoanId()).collect(Collectors.toList()));

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
            if(fine.getFineAmount()>0){
                listOfNewFines.add(fine);
            }
        });

        fineRepository.saveAll(listOfExistingFines);
        fineRepository.saveAll(listOfNewFines);
    }

    @Override
    public FineByBorrower getFineByBorrower(String borrowerId) {
        FineByBorrower fineByBorrower = new FineByBorrower();
        Borrower borrower = borrowerService.findBorrowerByBorrowerId(borrowerId);
        if(borrower==null){
            return null;
        }
        List<Fine> listOfUnpaidFinesByBorrowerForReturnedBooks = fineRepository.findAllByBookLoan_Borrower_BorrowerIdAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(borrowerId);
        if(listOfUnpaidFinesByBorrowerForReturnedBooks==null){
            return null;
        }
        fineByBorrower.setBorrower(borrower);
        fineByBorrower.setFines(listOfUnpaidFinesByBorrowerForReturnedBooks);
        TotalFine totalFine = new TotalFine();
        Double totalPayableFine = listOfUnpaidFinesByBorrowerForReturnedBooks.stream().mapToDouble(each->each.getFineAmount()).sum();
        totalFine.setPayableFine(totalPayableFine);
        fineByBorrower.setTotalFine(totalFine);
        return fineByBorrower;
    }

    @Override
    public void payFinesForAllReturnedBooksByBorrower(String borrowerId) {
        List<Fine> listOfUnpaidFinesByBorrowerForReturnedBooks = fineRepository.findAllByBookLoan_Borrower_BorrowerIdAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(borrowerId);
        if(listOfUnpaidFinesByBorrowerForReturnedBooks==null){
            return;
        }
        listOfUnpaidFinesByBorrowerForReturnedBooks.stream().forEach(each->{
            each.setPaidStatus(true);
        });
        fineRepository.saveAll(listOfUnpaidFinesByBorrowerForReturnedBooks);
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
        List<Fine> listOfUnpaidFinesByBorrowerForReturnedBooks = fineRepository.findAllByBookLoan_Borrower_BorrowerIdAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(borrower.getBorrowerId());

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
