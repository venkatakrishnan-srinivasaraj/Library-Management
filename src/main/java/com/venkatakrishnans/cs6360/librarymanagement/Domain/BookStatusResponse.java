package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

@Data
public class BookStatusResponse {

    private BookAuthorMap bookAuthorMap;
    private boolean isBookAvailableForBorrowing;

}
