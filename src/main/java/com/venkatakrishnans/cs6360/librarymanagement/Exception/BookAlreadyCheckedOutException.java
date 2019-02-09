package com.venkatakrishnans.cs6360.librarymanagement.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookAlreadyCheckedOutException extends  Exception {

    public BookAlreadyCheckedOutException(String errorMessage){
      super(errorMessage);
    }

}
