package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table
public class Fine implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "bookLoanId")
    private BookLoan bookLoan;

    @NotNull
    @NotEmpty
    private double fineAmount;

    @NotNull
    @NotEmpty
    private boolean paidStatus;

}
