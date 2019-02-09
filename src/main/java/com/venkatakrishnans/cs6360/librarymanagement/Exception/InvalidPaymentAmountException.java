package com.venkatakrishnans.cs6360.librarymanagement.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidPaymentAmountException extends  Exception {

    public InvalidPaymentAmountException(String errorMessage){
        super(errorMessage);
    }
}
