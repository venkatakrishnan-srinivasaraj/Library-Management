package com.venkatakrishnans.cs6360.librarymanagement.Domain;

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
@IdClass(BookAuthorKey.class)
public class BookAuthorMap {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Book book;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private Author author;

}
