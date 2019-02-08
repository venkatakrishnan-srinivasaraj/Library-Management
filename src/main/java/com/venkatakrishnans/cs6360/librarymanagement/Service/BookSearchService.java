package com.venkatakrishnans.cs6360.librarymanagement.Service;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookStatusResponse;

import java.util.List;

public interface BookSearchService {
     List<BookAuthorMap> getAllBooks();
     List<BookAuthorMap> searchBooks(String searchTerm);
     List<BookStatusResponse> searchBooksWithAvailabiltyStatus(String searchTerm);
}
