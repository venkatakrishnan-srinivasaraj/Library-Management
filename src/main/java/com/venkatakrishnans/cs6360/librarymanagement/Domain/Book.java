package com.venkatakrishnans.cs6360.librarymanagement.Domain;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "isbn10")})
@Builder
public class Book {

    @Id
    private String isbn13;

    @NotNull
    @NotEmpty
    private String isbn10;

    @NotNull
    @NotEmpty
    private String title;

    private String coverUrl;

    private String publisher;

    private int pages;
}
