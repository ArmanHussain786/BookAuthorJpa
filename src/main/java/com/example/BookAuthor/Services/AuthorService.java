package com.example.BookAuthor.Services;

import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Models.Book;
import com.example.BookAuthor.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {

        authorRepository.save(author);
        return "author added";
    }

    public int findTotal(Long authorId) {
        Author author = authorRepository.findById(authorId).get();
        List<Book> bookList = author.getBookList();
        int totalBooks=0;
        int ratings=6;
        for(Book book : bookList)
        {
            if(author.getRating()>ratings)
            {
                totalBooks++;
            }
        }
        return totalBooks;
    }
}
//        GET API:  Find out total no. the books who’s authors have rating greater than x