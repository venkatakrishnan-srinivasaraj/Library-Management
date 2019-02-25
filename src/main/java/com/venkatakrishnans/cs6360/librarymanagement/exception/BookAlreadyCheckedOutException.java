package com.venkatakrishnans.cs6360.librarymanagement.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookAlreadyCheckedOutException extends  Exception {

    public BookAlreadyCheckedOutException(String errorMessage){
      super(errorMessage);
    }

}
