package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.Service.LibraryDataImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataimport")
public class DataImportController {

    @Autowired
    private LibraryDataImportService libraryDataImportService;

    @RequestMapping("/")
    public String home(){
        libraryDataImportService.importBookAuthorDataFromFile();
        return "success";
    }
}
