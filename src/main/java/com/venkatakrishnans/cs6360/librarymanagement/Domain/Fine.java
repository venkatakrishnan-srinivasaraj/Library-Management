package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
    @NotEmpty
    private double fineAmount;

    @NotNull
    @NotEmpty
    private boolean paidStatus;

}
