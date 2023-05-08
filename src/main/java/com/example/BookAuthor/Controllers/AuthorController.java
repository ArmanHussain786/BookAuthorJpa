package com.example.BookAuthor.Controllers;


import com.example.BookAuthor.Models.Author;
import com.example.BookAuthor.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author)
    {
        authorService.addAuthor(author);
        return "added author";
    }
}
