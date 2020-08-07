package com.librarydata.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class SearchController {
    
    @Autowired
    private BookService searchBook;

    @GetMapping("/search")
    public ResponseEntity< List<Book>> getAllBooks() {
        return searchBook.getAllBooks();
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable String title) {
        return searchBook.findByTitle(title);
    }

    @GetMapping("/search/author/{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author){
        return searchBook.findByAuthor(author);
    }

    @GetMapping("/search/genere/{genere}")
    public ResponseEntity<List<Book>> findAllByGenere(@PathVariable String genere) {
        return searchBook.findAllByGenere(genere);
    }

    
    
    
}