package com.venkatakrishnans.cs6360.librarymanagement.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Author {

    @Id
    private String authorId;

    @NotNull
    @NotEmpty
    private String name;

}
