package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BorrowerRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BorrowerService;
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
