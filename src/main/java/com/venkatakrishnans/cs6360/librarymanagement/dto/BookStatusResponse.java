package com.venkatakrishnans.cs6360.librarymanagement.dto;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import lombok.Data;

@Data
public class BookStatusResponse {

    private BookAuthorMap bookAuthorMap;
    private boolean isBookAvailableForBorrowing;

}
