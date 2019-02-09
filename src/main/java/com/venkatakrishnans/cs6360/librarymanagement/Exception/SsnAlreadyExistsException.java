package com.venkatakrishnans.cs6360.librarymanagement.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SsnAlreadyExistsException extends  Exception {

    public SsnAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
