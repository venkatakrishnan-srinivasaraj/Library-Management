package com.venkatakrishnans.cs6360.librarymanagement.repository;

import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookAuthorMapRepository extends JpaRepository<BookAuthorMap,String> {

     List<BookAuthorMap> findAllByAuthorNameContainingOrBookTitleContainingOrBook_Isbn10ContainingOrBook_Isbn13Containing(String authorName,String bookTitle,String isbn10,String isbn13);
}