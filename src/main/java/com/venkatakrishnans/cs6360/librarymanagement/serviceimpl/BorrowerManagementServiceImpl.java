package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.SsnAlreadyExistsException;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BorrowerRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerManagementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BorrowerManagementServiceImpl implements BorrowerManagementService {

     private final BorrowerRepository borrowerRepository;

     @Override
     public void createBorrower(Borrower borrower) throws SsnAlreadyExistsException {
          Borrower existingBorrowerWithGivenSsn = borrowerRepository.findBySsn(borrower.getSsn());
          if(existingBorrowerWithGivenSsn != null){
               throw new SsnAlreadyExistsException();
          }
          borrowerRepository.save(borrower);
     }

     @Override
     public Borrower findByBorrowerId(String borrowerId) {
          return borrowerRepository.findByBorrowerId(borrowerId);
     }
}
