package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Author;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.repository.AuthorRepository;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookAuthorMapRepository;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookRepository;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BorrowerRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.LibraryDataImportService;
import com.venkatakrishnans.cs6360.librarymanagement.util.BookAuthorCsvMap;
import com.venkatakrishnans.cs6360.librarymanagement.util.BorrowerMap;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibraryDataImportServiceImpl implements LibraryDataImportService {

    //To-do change to application properties
    private static final String SAMPLE_CSV_FILE_PATH_BOOKS = "/Users/venkatakrishnansrinivasaraj/IdeaProjects/Library-Management/src/main/resources/data/books.csv";

    //To-do change to application properties
    private static final String SAMPLE_CSV_FILE_PATH_BORROWER = "/Users/venkatakrishnansrinivasaraj/IdeaProjects/Library-Management/src/main/resources/data/borrowers.csv";

    private final BookAuthorMapRepository bookAuthorMapRepository;

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final BorrowerRepository borrowerRepository;

    @Override
    public void importBookAuthorDataFromFile() {
        //To-do
        try(Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH_BOOKS))){
            CsvToBean<BookAuthorCsvMap> csvToBean = new CsvToBeanBuilder(reader)
                                                    .withType(BookAuthorCsvMap.class)
                                                    .withSkipLines(1)
                                                    .withSeparator('\t')
                                                    .build();

            List<BookAuthorCsvMap> bookAuthorCsvMapList = csvToBean.parse();

            List<BookAuthorMap> bookAuthorMapList = bookAuthorCsvMapList.parallelStream().map(BookAuthorCsvMap::toBookAuthorMap).collect(Collectors.toList());

//            List<Book> bookList = bookAuthorMapList.parallelStream().map(each->each.getBook()).collect(Collectors.toList());
//
//            List<Author> authorList = bookAuthorMapList.parallelStream().map(each->each.getAuthor()).collect(Collectors.toList());

//            List<BookAuthorMap> invalid = bookAuthorMapList.parallelStream().filter(each -> each.getAuthor().getName() == null).collect(Collectors.toList());
//
//            System.out.println(invalid);

//            bookRepository.saveAll(bookList);
//
//            authorRepository.saveAll(authorList);

            bookAuthorMapRepository.saveAll(bookAuthorMapList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void importBorrowersDataFromFile() {
        //To-do
        try(Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH_BORROWER))){
            CsvToBean<BorrowerMap> csvToBean = new CsvToBeanBuilder(reader)
                                                .withType(BorrowerMap.class)
                                                .withSkipLines(1)
                                                .withSeparator(',')
                                                .build();

            List<BorrowerMap> borrowerMapList = csvToBean.parse();

            List<Borrower> bookAuthorMapList = borrowerMapList.stream().map(each -> each.toBorrower()).collect(Collectors.toList());
            borrowerRepository.saveAll(bookAuthorMapList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
