package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookAuthorMapRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSearchServiceImpl implements BookSearchService {

     @Autowired
     private BookAuthorMapRepository bookAuthorMapRepository;

     @Override
     public List<BookAuthorMap> getAllBooks() {
          return bookAuthorMapRepository.findAll();
     }

     @Override
     public List<BookAuthorMap> searchBooks(String searchTerm) {
          return bookAuthorMapRepository.findAllByAuthorNameContainingOrBookTitleContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(searchTerm,searchTerm,searchTerm,searchTerm);
     }
}
