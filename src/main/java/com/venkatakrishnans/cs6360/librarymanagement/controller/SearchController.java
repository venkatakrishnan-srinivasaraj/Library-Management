package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private BookSearchService bookSearchService;

    @RequestMapping("/{searchTerm}")
    public List<BookAuthorMap> search(@PathVariable String searchTerm){
        return bookSearchService.searchBooks(searchTerm);
    }
}
