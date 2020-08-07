package com.librarydata.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
   
    public Book findByTitle(String title);

    public Optional<Book> findByAuthor(String author);

    public Iterable<Book> findAllByAuthor(String author);
    
    public Iterable<Book> findAllByGenere(String genere);

	public Optional<Book> findById(Long id);

    public void deleteById(Long id);

    public Iterable<Book> findAllByCheckOutStatus(Boolean checkOutStatus);
    
}