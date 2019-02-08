package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSearchServiceImpl implements BookSearchService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book findBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    @Override
    public Book findBookByIsbn13(String isbn13){
        return bookRepository.findBookByIsbn13(isbn13);
    }

    @Override
    public Book findBookByIsbn10(String isbn10){
        return bookRepository.findBookByIsbn10(isbn10);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
