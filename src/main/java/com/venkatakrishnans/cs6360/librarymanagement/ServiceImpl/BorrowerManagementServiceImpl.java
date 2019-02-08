package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.SsnAlreadyExistsException;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BorrowerRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BorrowerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowerManagementServiceImpl implements BorrowerManagementService {

     @Autowired
     private BorrowerRepository borrowerRepository;

     @Override
     public void createBorrower(Borrower borrower) throws SsnAlreadyExistsException {
          Borrower existingBorrowerWithGivenSsn = borrowerRepository.findBySsn(borrower.getSsn());
          if(existingBorrowerWithGivenSsn != null){
               throw new SsnAlreadyExistsException();
          }
          borrowerRepository.save(borrower);
     }
}
