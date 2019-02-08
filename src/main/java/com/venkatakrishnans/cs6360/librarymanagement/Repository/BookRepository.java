package com.venkatakrishnans.cs6360.librarymanagement.Repository;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book,String> {

    public Book findBookByTitle(String title);

    public Book findBookByIsbn10(String isbn10);

    public Book findBookByIsbn13(String isbn13);
}
