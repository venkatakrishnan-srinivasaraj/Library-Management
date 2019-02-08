package com.venkatakrishnans.cs6360.librarymanagement.Repository;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface BookLoanRepository extends JpaRepository<BookLoan,String> {

     BookLoan findByBookIsAndReturnDateIsNull(Book book);

     long countAllBookIsAndReturnDateIsNull(Book book);

     List<BookLoan> findAllByBookInAndReturnDateIsNull(List<Book> bookList);

     long countAllByBorrowerIsAndAndReturnDateIsNull(Borrower borrower);

     List<BookLoan> findAllByBorrowerIsAndAndReturnDateIsNotNull(Borrower borrower, Date returnDate);

     List<BookLoan> findAllByReturnDateIsNull();

     List<BookLoan> findAllByReturnDateIsNullAndBorrowerBorrowerIdContainingOrBorrowerFirstNameContainingOrBorrowerLastNameContainingOrBookIsbn10ContainingOrBookIsbn13Containing(String borrowerId,String firstName,String lastName,String isbn10,String isbn13);

}