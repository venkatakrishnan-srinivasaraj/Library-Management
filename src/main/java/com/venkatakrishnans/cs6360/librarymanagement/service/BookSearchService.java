package com.venkatakrishnans.cs6360.librarymanagement.service;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookStatusResponse;

import java.util.List;

public interface BookSearchService {
     List<BookAuthorMap> getAllBooks();
     List<BookAuthorMap> searchBooks(String searchTerm);
     List<BookStatusResponse> searchBooksWithAvailabiltyStatus(String searchTerm);
}
