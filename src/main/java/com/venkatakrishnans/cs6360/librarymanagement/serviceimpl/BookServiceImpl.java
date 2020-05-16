package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

     private final BookRepository bookRepository;

     @Override
     public Book findBookByIsbn13(String isbn13) {
          Optional<Book> book = bookRepository.findById(isbn13);
          if(book.isPresent()){
               return book.get();
          }
          return null;
     }
}
