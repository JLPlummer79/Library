package com.librarydata.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public ResponseEntity< List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }
    @RequestMapping("/books/{id}")
    public ResponseEntity <Book> getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
       return bookService.addBook(book);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(book, id);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
       return  bookService.deleteBook(id);
    }
    
}
