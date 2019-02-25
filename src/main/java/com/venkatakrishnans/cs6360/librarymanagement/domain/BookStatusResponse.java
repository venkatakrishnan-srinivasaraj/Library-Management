package com.venkatakrishnans.cs6360.librarymanagement.domain;

import lombok.Data;

@Data
public class BookStatusResponse {

    private BookAuthorMap bookAuthorMap;
    private boolean isBookAvailableForBorrowing;

}
