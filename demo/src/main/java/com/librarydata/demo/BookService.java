package com.librarydata.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//note, this class will handle the @Repository requests

public class BookService {
   
    @Autowired
    private BookRepository bookrepository;

    public ResponseEntity <List<Book>> getAllBooks() {
        try{
            List<Book> books = new ArrayList<Book>();
            bookrepository.findAll()
            .forEach(books::add);
            if(books.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        }    
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity <Book> getBook(Long id) {
        Optional <Book> bookOptional = bookrepository.findById(id); 
        if(bookOptional.isPresent()) {
            return new ResponseEntity<>(bookOptional.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
    
    public ResponseEntity <List<Book>> findByAuthor(String author) {
        try {
                List<Book> books = new ArrayList<>();
                bookrepository.findAllByAuthor(author).
                forEach(books::add);
                if(books.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    public ResponseEntity <List<Book>> findAllByGenere(String genere) {
        try {
                List<Book> books = new ArrayList<>();
                bookrepository.findAllByGenere(genere
                ).
                forEach(books::add);
                if(books.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    //Change back to using Optional, it is safer
    public ResponseEntity <Book> findByTitle(String title) {
        
        try{
            Book book = bookrepository.findByTitle(title);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Book> addBook(Book book) {
        try{
           Book savedBook = bookrepository.save(book);
           return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Book> updateBook(Book book, Long id) {
        Optional<Book> bookOptional = bookrepository.findById(id);
        if(bookOptional.isPresent()){
            return new ResponseEntity<>(bookrepository.save(book), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	public ResponseEntity<HttpStatus> deleteBook(Long id) {
        try{
            bookrepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity <List<Book>> findAllByCheckOutStatus(Boolean checkOutStatus) {
        try {
                List<Book> books = new ArrayList<>();
                bookrepository.findAllByCheckOutStatus(checkOutStatus).
                forEach(books::add);
                if(books.isEmpty()){
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}