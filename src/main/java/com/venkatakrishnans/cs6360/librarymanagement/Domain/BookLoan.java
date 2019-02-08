package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"bookId", "borrowerId"}))
public class BookLoan {

    @Id
    private String bookLoanId;

    @OneToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @OneToOne
    @JoinColumn(name = "borrowerId")
    private Borrower borrower;

    @NotNull
    @NotEmpty
    private Date checkoutDate;

    @NotNull
    @NotEmpty
    private Date dueDate;

    private Date returnDate;

}