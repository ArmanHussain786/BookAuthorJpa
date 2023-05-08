package com.example.BookAuthor.Controllers;

import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Services.AuthorService;
import com.example.BookAuthor.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @PostMapping("add")
    public String addBook(@RequestBody Book book)
    {
        bookService.addBook(book);
        return "added successfully";
    }

    @GetMapping("/find_highest")
    public String findHighest(@RequestParam Long bookId)
    {
        bookService.findHighest(bookId);
        return "this is highest";
    }

    @PutMapping("/update")
    public String updateBook(@RequestParam Book book , @RequestParam int pages)
    {
        bookService.updateBook(book,pages);
        return "book updated";
    }
    @GetMapping("/total_books")
    public String findTotal(@RequestParam Long authorId)
    {
        authorService.findTotal(authorId);
        return "total book is here";
    }
}


//    Book {
//        Long id;
//        String name;
//        int pages;
//        Author author;
//    }
//
//    Author {
//        Long id;
//        String name;
//        int rating;
//    }
//
//    POST API : Add Book
//        POST API : Add author
//
//        GET API  : Find the bookName with highest no. of pages.
//        PUT API : Update the number of pages for a specific book by specifying its name in the path and providing the updated number of pages.
//GET API:  Find out total no. the books who’s authors have rating greater than x