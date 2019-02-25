package com.venkatakrishnans.cs6360.librarymanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fine{

    @Id
    private long fineId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "bookLoanId")
    private BookLoan bookLoan;

    @NotNull
    private double fineAmount;

    @NotNull
    private boolean paidStatus;

}
