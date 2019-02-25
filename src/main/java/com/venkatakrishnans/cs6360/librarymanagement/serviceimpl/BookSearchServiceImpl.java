package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookLoan;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookStatusResponse;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookAuthorMapRepository;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookLoanRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookSearchServiceImpl implements BookSearchService {

     @Autowired
     private BookAuthorMapRepository bookAuthorMapRepository;

     @Autowired
     private BookLoanRepository bookLoanRepository;

     @Override
     public List<BookAuthorMap> getAllBooks() {
          List<BookAuthorMap> listOfBookAuthorMap =  bookAuthorMapRepository.findAll();
          return listOfBookAuthorMap;
     }

     @Override
     public List<BookStatusResponse> searchBooksWithAvailabiltyStatus(String searchTerm) {
          List<BookAuthorMap> listOfBookAuthorMap = bookAuthorMapRepository.findAllByAuthorNameContainingOrBookTitleContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(searchTerm,searchTerm,searchTerm,searchTerm);
          List<BookStatusResponse> bookStatusResponseList= constructBookAvailabilityStatusResponse(listOfBookAuthorMap);
          return bookStatusResponseList;
     }

     @Override
     public List<BookAuthorMap> searchBooks(String searchTerm) {
          List<BookAuthorMap> listOfBookAuthorMap = bookAuthorMapRepository.findAllByAuthorNameContainingOrBookTitleContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(searchTerm,searchTerm,searchTerm,searchTerm);
          return listOfBookAuthorMap;
     }

     private List<BookStatusResponse> constructBookAvailabilityStatusResponse(List<BookAuthorMap> listOfBookAuthorMap) {
          List<BookStatusResponse> bookStatusResponseList = new ArrayList<>();
          List<BookLoan> listOfUnAvailableBooks = bookLoanRepository.findAllByBookInAndReturnDateIsNotNull(listOfBookAuthorMap.stream().map(each->each.getBook()).collect(Collectors.toList()));
          listOfBookAuthorMap.stream().forEach(each->{
               BookStatusResponse bookStatusResponse = new BookStatusResponse();
               bookStatusResponse.setBookAuthorMap(each);
               if(listOfUnAvailableBooks.contains(each.getBook())){
                    bookStatusResponse.setBookAvailableForBorrowing(false);
               }else{
                    bookStatusResponse.setBookAvailableForBorrowing(true);
               }
               bookStatusResponseList.add(bookStatusResponse);
          });
          return bookStatusResponseList;
     }


}
