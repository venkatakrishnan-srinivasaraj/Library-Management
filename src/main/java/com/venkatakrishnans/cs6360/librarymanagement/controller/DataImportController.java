package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.service.LibraryDataImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataimport")
public class DataImportController {

    @Autowired
    private LibraryDataImportService libraryDataImportService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/book")
    public String importBooks(){
        libraryDataImportService.importBookAuthorDataFromFile();
        return "successfullyImportedBooks";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/borrower")
    public String importBorrowers(){
        libraryDataImportService.importBorrowersDataFromFile();
        return "successfullyImportedBorrower";
    }
}
