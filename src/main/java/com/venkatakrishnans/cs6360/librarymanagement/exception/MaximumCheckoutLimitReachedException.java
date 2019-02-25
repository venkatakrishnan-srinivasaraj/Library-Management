package com.venkatakrishnans.cs6360.librarymanagement.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MaximumCheckoutLimitReachedException extends  Exception {

    public MaximumCheckoutLimitReachedException(String errorMessage){
        super(errorMessage);
    }
}
