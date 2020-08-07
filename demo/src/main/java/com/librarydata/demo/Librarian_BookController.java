package com.librarydata.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//handles the librian/book request operations
public class Librarian_BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("librarian/book")
    public String home() {
        return "Welcome to the Ankmorpork Library<br/>"+System.lineSeparator()+
        "=======================================<br/>"+ System.lineSeparator()+
        "librarian/book/search: entire catalogue<br/>"+System.lineSeparator()+
        "librarian/book/search{id}: search book by id<br/>"+System.lineSeparator()+
        "librarian/book/search/{title}: search book by title<br/>"+System.lineSeparator()+
        "librarian/book/search/{author}: search books by author<br/>"+System.lineSeparator()+
        "librarian/book/search/{genere}: search by genere<br/>"+System.lineSeparator()+
        "librarian/book/checked-out: all books checked out{true/false}<br/>"+System.lineSeparator()+
        "librarian/book/: menu for add, update, delete, and check-in books<br/>"+System.lineSeparator()+
        "=======================================<br/>"+ System.lineSeparator();
    }

    //get all Books in library
    @RequestMapping("librarian/book/search")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }
    //search books by id number
    @RequestMapping("librarian/book/search/{id}")
    public ResponseEntity <Book> getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }
    //search books by title
    @RequestMapping("librarian/book/search/title/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }
    //search books by author
    @RequestMapping("librarian/book/search/author/{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author){
        return bookService.findByAuthor(author);
    }
    //search books by genere
    @RequestMapping("librarian/book/search/genere/{genere}")
    public ResponseEntity<List<Book>> findAllByGenere(@PathVariable String genere) {
        return bookService.findAllByGenere(genere);
    }

    @RequestMapping("librarian/book/")
    public String bookMessage() {
     return "Welcome to the Ankmorpork Library<br/>"+System.lineSeparator()+
            "=======================================<br/>"+ System.lineSeparator()+
            "librarian/book/update/{id} : update book fields by id<br/>"+ System.lineSeparator()+
            "librarian/book/delete/{id} : delete book by id<br/>"+System.lineSeparator()+
            "librarian/book/new: add new book record<br/>"+System.lineSeparator()+
        "=======================================<br/>"+ System.lineSeparator();
    }
    
    //update book information, including checked-in/check-out
    @PutMapping("librarian/book/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(book, id);
    }
    //delete a book record from the data base
    @DeleteMapping("librarian/book/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long id) {
        return  bookService.deleteBook(id);
     }
     
     @RequestMapping("librarian/book/checked-out/{checkOutStatus}")
     public ResponseEntity<List<Book>> findCheckedOut(@PathVariable Boolean checkOutStatus){
         return bookService.findAllByCheckOutStatus(checkOutStatus);
     }
     @PostMapping("librarian/book/new")
     public ResponseEntity<Book> updateBook(@RequestBody Book book){
         return bookService.addBook(book);
     }

}