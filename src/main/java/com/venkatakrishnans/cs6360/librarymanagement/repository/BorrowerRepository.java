package com.venkatakrishnans.cs6360.librarymanagement.repository;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BorrowerRepository extends JpaRepository<Borrower,String> {

    Borrower findByBorrowerId(String borrowerId);

    Borrower findBySsn(String ssn);

}
