package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "isbn10")})
public class Book {

    @Id
    private String isbn13;

    @NotNull
    private String isbn10;

    @NotNull
    private String title;
}
