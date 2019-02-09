package com.venkatakrishnans.cs6360.librarymanagement.Util;

import com.opencsv.bean.CsvBindByPosition;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import lombok.Data;

@Data
public class BorrowerMap {

    @CsvBindByPosition(position = 0)
    private String borrowerId;

    @CsvBindByPosition(position = 1)
    private String ssn;

    @CsvBindByPosition(position = 2)
    private String firstName;

    @CsvBindByPosition(position = 3)
    private String lastName;

    @CsvBindByPosition(position = 4)
    private String email;

    @CsvBindByPosition(position = 5)
    private String address;

    @CsvBindByPosition(position = 6)
    private String city;

    @CsvBindByPosition(position = 7)
    private String state;

    @CsvBindByPosition(position = 8)
    private String phone;

    public Borrower toBorrower(){
        String concatenatedAddress = new StringBuilder().append(address).append(",").append(city).append(",").append(state).toString();
       Borrower borrower = Borrower.builder()
               .borrowerId(borrowerId)
               .ssn(ssn)
               .firstName(firstName)
               .lastName(lastName)
               .email(email)
               .address(concatenatedAddress)
               .phoneNumber(phone)
               .build();
       return borrower;
    }
}
