package com.venkatakrishnans.cs6360.librarymanagement.repository;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Author;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorRepository extends JpaRepository<Author,Long> {


}
