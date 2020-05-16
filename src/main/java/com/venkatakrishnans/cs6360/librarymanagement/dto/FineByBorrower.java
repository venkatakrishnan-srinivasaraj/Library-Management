package com.venkatakrishnans.cs6360.librarymanagement.dto;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Fine;
import lombok.Data;

import java.util.List;

@Data
public class FineByBorrower {

    private Borrower borrower;
    private List<Fine> fines;
    private TotalFine totalFine;

}
