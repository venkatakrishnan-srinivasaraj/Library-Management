package com.venkatakrishnans.cs6360.librarymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookLoan {

    @Id
    @GeneratedValue
    private long bookLoanId;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "borrowerId")
    private Borrower borrower;

    @NotNull
    private Date checkoutDate;

    @NotNull
    private Date dueDate;

    private Date returnDate;

}
