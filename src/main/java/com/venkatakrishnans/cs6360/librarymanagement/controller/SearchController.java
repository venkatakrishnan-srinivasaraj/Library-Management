package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookStatusResponse;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private BookSearchService bookSearchService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/{searchTerm}")
    public List<BookStatusResponse> search(@PathVariable String searchTerm){
        return bookSearchService.searchBooksWithAvailabiltyStatus(searchTerm);
    }
}
