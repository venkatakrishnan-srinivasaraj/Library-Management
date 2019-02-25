package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BorrowerRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

     @Autowired
     BorrowerRepository borrowerRepository;

     @Override
     public Borrower findBorrowerByBorrowerId(String borrowerId) {
          return borrowerRepository.findByBorrowerId(borrowerId);
     }
}
