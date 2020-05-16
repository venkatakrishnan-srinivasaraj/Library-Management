package com.venkatakrishnans.cs6360.librarymanagement.dto;

import lombok.Data;

@Data
public class BookCheckinRequest {

    private String isbn13;

    private long borrowerId;
}
