package com.example.BookAuthor.Services;


import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public String addBook(Book book) {
        bookRepository.save(book);
        return "book added successfully";
    }

    public String findHighest(Long bookId) {

        Book book = bookRepository.findById(bookId).get();
        List<Book> books = book.getAuthor().getBookList();
        String bookName = "";
        int pages =0;
        for(Book book1 :books)
        {
            if(book1.getPages()>pages)
            {
                pages=book1.getPages();
                bookName = book1.getName();
            }
        }
        return bookName;
    }

    public String updateBook(Book book, int pages) {
        Long id = book.getId();
        Book book1 = bookRepository.findById(id).get();
        book1.setPages(book1.getPages()+pages);
        bookRepository.save(book1);
        return "Book updated";
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
//        GET API:  Find out total no. the books who’s authors have rating greater than x