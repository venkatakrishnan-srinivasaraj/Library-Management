package com.venkatakrishnans.cs6360.librarymanagement.util;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Author;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import lombok.Data;

@Data
public class BookAuthorCsvMap {

    @CsvBindByName(column = "ISBN10")
    @CsvBindByPosition(position = 0)
    private String isbn10;

    @CsvBindByName(column = "ISBN13")
    @CsvBindByPosition(position = 1)
    private String isbn13;

    @CsvBindByName(column = "Title")
    @CsvBindByPosition(position = 2)
    private String title;

    @CsvBindByName(column = "Author")
    @CsvBindByPosition(position = 3)
    private String authorName;

    @CsvBindByName(column = "Cover")
    @CsvBindByPosition(position = 4)
    private String coverUrl;

    @CsvBindByName(column = "Publisher")
    @CsvBindByPosition(position = 5)
    private String publisherName;

    @CsvBindByName(column = "Pages")
    @CsvBindByPosition(position = 6)
    private int pages;

    public BookAuthorMap toBookAuthorMap(){
        Author author = Author.builder().name(authorName).build();
        Book book = Book.builder().isbn10(isbn10)
                .isbn13(isbn13)
                .title(title)
                .coverUrl(coverUrl)
                .publisher(publisherName)
                .pages(pages)
                .build();
        return BookAuthorMap.builder().author(author).book(book).build();
    }
}
