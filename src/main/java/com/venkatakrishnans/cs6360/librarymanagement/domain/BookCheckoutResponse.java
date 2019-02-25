package com.venkatakrishnans.cs6360.librarymanagement.domain;

import lombok.Data;

@Data
public class BookCheckoutResponse {

    private String checkoutStatus;

    private String message;

}
