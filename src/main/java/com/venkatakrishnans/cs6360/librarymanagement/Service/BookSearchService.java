package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;

import java.util.List;

public interface BookSearchService {
     List<Book> getAllBooks();
     Book findBookByTitle(String title);
     Book findBookByIsbn13(String isbn13);
     Book findBookByIsbn10(String isbn10);
     void save(Book book);
}
