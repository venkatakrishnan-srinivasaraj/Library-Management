package com.venkatakrishnans.cs6360.librarymanagement.serviceimpl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BookAuthorMapRepository;
import com.venkatakrishnans.cs6360.librarymanagement.repository.BorrowerRepository;
import com.venkatakrishnans.cs6360.librarymanagement.service.LibraryDataImportService;
import com.venkatakrishnans.cs6360.librarymanagement.util.BookAuthorCsvMap;
import com.venkatakrishnans.cs6360.librarymanagement.util.BorrowerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryDataImportServiceImpl implements LibraryDataImportService {

    //To-do change to application properties
    private static final String SAMPLE_CSV_FILE_PATH_BOOKS = "C:\\Java Workspace\\Library-Management\\src\\main\\resources\\data\\samplebooks.csv";

    //To-do change to application properties
    private static final String SAMPLE_CSV_FILE_PATH_BORROWER = "C:\\Java Workspace\\Library-Management\\src\\main\\resources\\data\\sampleborrowers.csv";

    @Autowired
    private BookAuthorMapRepository bookAuthorMapRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

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

            List<BookAuthorMap> bookAuthorMapList = bookAuthorCsvMapList.stream().map(each -> each.toBookAuthorMap()).collect(Collectors.toList());
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
