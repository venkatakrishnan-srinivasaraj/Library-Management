package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "ssn")})
public class Borrower {

    @Id
    @GeneratedValue
    private String borrowerId;

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String ssn;

    private String email;

    private String address;

    private String phoneNumber;

}
