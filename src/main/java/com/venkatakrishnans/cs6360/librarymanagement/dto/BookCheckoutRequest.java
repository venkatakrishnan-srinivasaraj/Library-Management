package com.venkatakrishnans.cs6360.librarymanagement.dto;

import lombok.Data;

@Data
public class BookCheckoutRequest {

    private String isbn13;

    private String borrowerId;
}
