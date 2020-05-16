package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.service.LibraryDataImportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataimport")
@AllArgsConstructor
public class DataImportController {

    private final LibraryDataImportService libraryDataImportService;

    @RequestMapping("/book")
    public String importBooks(){
        libraryDataImportService.importBookAuthorDataFromFile();
        return "successfullyImportedBooks";
    }

    @RequestMapping("/borrower")
    public String importBorrowers(){
        libraryDataImportService.importBorrowersDataFromFile();
        return "successfullyImportedBorrower";
    }
}
