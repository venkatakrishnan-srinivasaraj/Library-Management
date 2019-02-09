package com.venkatakrishnans.cs6360.librarymanagement.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MaximumCheckoutLimitReachedException extends  Exception {

    public MaximumCheckoutLimitReachedException(String errorMessage){
        super(errorMessage);
    }
}
