package com.example.BookAuthor.Models;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int rating;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

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
