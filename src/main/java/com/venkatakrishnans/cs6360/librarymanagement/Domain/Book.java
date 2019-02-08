package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "isbn10")})
public class Book {

    @Id
    @Column(name = "ISBN13")
    private String isbn13;

    @NotNull
    @Column(name = "ISBN10")
    private String isbn10;

    @NotNull
    @Column(name = "TITLE")
    private String title;
}
