package com.venkatakrishnans.cs6360.librarymanagement.repository;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookLoanRepository extends JpaRepository<BookLoan,String> {

//     BookLoan findByBookIsAndReturnDateIsNull(Book book,Date returnDate);

     BookLoan findByBookLoanId(long bookLoanId);

     long countAllByBookAndReturnDateIsNull(Book book);

     List<BookLoan> findAllByBookInAndReturnDateIsNotNull(List<Book> bookList);

     long countAllByBorrowerAndReturnDateIsNull(Borrower borrower);

//     List<BookLoan> findAllByBorrowerBorrowerIdIsAndAndReturnDateIsNotNull(String borrowerId, Date returnDate);

     List<BookLoan> findAllByReturnDateIsNull();

     List<BookLoan> findAllByReturnDateIsNullAndBorrowerBorrowerIdContainingOrBorrowerFirstNameContainingOrBorrowerLastNameContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(String borrowerId,String firstName,String lastName,String isbn10,String isbn13);

}