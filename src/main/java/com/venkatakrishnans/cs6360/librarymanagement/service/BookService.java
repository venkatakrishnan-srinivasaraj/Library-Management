package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;

public interface BookService {
     Book findBookByIsbn13(String isbn13);
}
