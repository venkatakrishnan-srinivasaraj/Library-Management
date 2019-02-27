package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookCheckoutRequest;
import com.venkatakrishnans.cs6360.librarymanagement.domain.BookCheckoutResponse;
import com.venkatakrishnans.cs6360.librarymanagement.domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.exception.BookAlreadyCheckedOutException;
import com.venkatakrishnans.cs6360.librarymanagement.exception.MaximumCheckoutLimitReachedException;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookCheckoutService;
import com.venkatakrishnans.cs6360.librarymanagement.service.BookService;
import com.venkatakrishnans.cs6360.librarymanagement.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/checkout")
public class BookCheckoutController {

    @Autowired
    private BookCheckoutService bookCheckoutService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/")
    @PostMapping
    public BookCheckoutResponse checkoutBook(@RequestBody BookCheckoutRequest bookCheckoutRequest){
        Book book = bookService.findBookByIsbn13(bookCheckoutRequest.getIsbn13());
        Borrower borrower = borrowerService.findBorrowerByBorrowerId(bookCheckoutRequest.getBorrowerId());
        BookCheckoutResponse bookCheckoutResponse = new BookCheckoutResponse();
        if(borrower==null){
            bookCheckoutResponse.setCheckoutStatus("failure");
            bookCheckoutResponse.setMessage("user is not registered in the system so cannot perform checkout");
            return bookCheckoutResponse;
        }
        try {
            bookCheckoutService.checkoutBookForBorrower(book,borrower);
            bookCheckoutResponse.setCheckoutStatus("success");
            bookCheckoutResponse.setMessage("Book checked-out successfully");
        } catch (BookAlreadyCheckedOutException e) {
            bookCheckoutResponse.setCheckoutStatus("failure");
            bookCheckoutResponse.setMessage(e.getMessage());
        } catch (MaximumCheckoutLimitReachedException e) {
            bookCheckoutResponse.setCheckoutStatus("failure");
            bookCheckoutResponse.setMessage(e.getMessage());
        }
        return bookCheckoutResponse;
    }
}
