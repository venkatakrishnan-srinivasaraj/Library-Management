package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book findBookByTitle(String title);
    public Book findBookByIsbn13(String isbn13);
    public Book findBookByIsbn10(String isbn10);
    public void save(Book book);
}
