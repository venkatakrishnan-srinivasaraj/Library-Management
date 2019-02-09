package com.venkatakrishnans.cs6360.librarymanagement.controller;

import com.venkatakrishnans.cs6360.librarymanagement.Domain.Book;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookCheckoutRequest;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.BookCheckoutResponse;
import com.venkatakrishnans.cs6360.librarymanagement.Domain.Borrower;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.BookAlreadyCheckedOutException;
import com.venkatakrishnans.cs6360.librarymanagement.Exception.MaximumCheckoutLimitReachedException;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookCheckoutService;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BookService;
import com.venkatakrishnans.cs6360.librarymanagement.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/checkout")
public class BookCheckoutController {

    @Autowired
    private BookCheckoutService bookCheckoutService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    @RequestMapping("/")
    @PostMapping
    public BookCheckoutResponse checkoutBook(@RequestBody BookCheckoutRequest bookCheckoutRequest){
        Book book = bookService.findBookByIsbn13(bookCheckoutRequest.getIsbn13());
        Borrower borrower = borrowerService.findBorrowerByBorrowerId(String.valueOf(bookCheckoutRequest.getBorrowerId()));
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
