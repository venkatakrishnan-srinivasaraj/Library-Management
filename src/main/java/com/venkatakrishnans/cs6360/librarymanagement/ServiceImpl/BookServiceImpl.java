package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

     @Autowired
     BookRepository bookRepository;

     @Override
     public Book findBookByIsbn13(String isbn13) {
          Optional<Book> book = bookRepository.findById(isbn13);
          if(book.isPresent()){
               return book.get();
          }
          return null;
     }
}
