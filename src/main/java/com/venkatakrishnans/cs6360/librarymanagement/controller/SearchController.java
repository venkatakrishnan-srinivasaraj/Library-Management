package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.dto.BookStatusResponse;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    private final BookSearchService bookSearchService;

    @RequestMapping("/{searchTerm}")
    public List<BookStatusResponse> search(@PathVariable String searchTerm){
        return bookSearchService.searchBooksWithAvailabiltyStatus(searchTerm);
    }
}
