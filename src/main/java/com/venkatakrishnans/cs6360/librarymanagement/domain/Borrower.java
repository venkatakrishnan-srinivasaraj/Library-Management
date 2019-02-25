package com.venkatakrishnans.cs6360.librarymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "ssn")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Borrower {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
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
