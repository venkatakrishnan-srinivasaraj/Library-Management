package com.venkatakrishnans.cs6360.librarymanagement.Repository;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FineRepository extends JpaRepository<Fine,String> {

//    List<Fine> findAllByPaidStatusIsFalse();

    List<Fine> findAllByBookLoan_BookLoanIdIn(List<Long> bookLoanIds);

    List<Fine> findAllByBookLoan_BorrowerAndPaidStatusIsFalse(Borrower borrower);

    List<Fine> findAllByBookLoan_Borrower_BorrowerIdAndBookLoanReturnDateIsNotNullAndPaidStatusIsFalse(String borrowerId);

}
