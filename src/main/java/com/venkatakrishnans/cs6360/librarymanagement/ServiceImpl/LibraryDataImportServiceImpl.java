package com.venkatakrishnans.cs6360.librarymanagement.ServiceImpl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookAuthorMap;
import com.venkatakrishnans.cs6360.librarymanagement.Repository.BookAuthorMapRepository;
import com.venkatakrishnans.cs6360.librarymanagement.Service.LibraryDataImportService;
import com.venkatakrishnans.cs6360.librarymanagement.Util.BookAuthorCsvMap;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryDataImportServiceImpl implements LibraryDataImportService {

    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Java Workspace\\Library-Management\\src\\main\\resources\\data\\samplebooks.csv";

    @Autowired
    private BookAuthorMapRepository bookAuthorMapRepository;

    @Override
    public void importBookAuthorDataFromFile() {
        //To-do
        try(Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))){
            CsvToBean<BookAuthorCsvMap> csvToBean = new CsvToBeanBuilder(reader)
                                                    .withType(BookAuthorCsvMap.class)
                                                    .withSkipLines(1)
                                                    .withIgnoreLeadingWhiteSpace(true)
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
    }
}
