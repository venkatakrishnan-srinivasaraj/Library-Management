package com.venkatakrishnans.cs6360.librarymanagement.domain;

import lombok.Data;

import java.util.List;

@Data
public class FineByBorrower {

    Borrower borrower;
    List<Fine> fines;
    TotalFine totalFine;

}
