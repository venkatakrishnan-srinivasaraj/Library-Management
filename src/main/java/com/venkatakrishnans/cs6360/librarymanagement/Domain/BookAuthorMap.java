package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"bookId","authorId"})})
@Table
@IdClass(BookAuthorKey.class)
public class BookAuthorMap {

    @Id
    @OneToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @Id
    @OneToOne
    @JoinColumn(name = "authorId")
    private Author author;

}
