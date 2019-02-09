package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;

public interface BookService {
     Book findBookByIsbn13(String isbn13);
}
