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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"bookId", "borrowerId"}))
public class BookLoan {

    @Id
    @GeneratedValue
    private long bookLoanId;

    @OneToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @OneToOne
    @JoinColumn(name = "borrowerId")
    private Borrower borrower;

    @NotNull
    private Date checkoutDate;

    @NotNull
    private Date dueDate;

    private Date returnDate;

}
