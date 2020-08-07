package com.librarydata.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String genere;
    private boolean checkOutStatus = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Book() {
    }

    public Book(String title, String author, String genere, Customer customer, boolean check) {
        super();
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.customer = customer;
        this.checkOutStatus = check;
    }

    public String getAuthor() {
        return author;
    }
    public String getGenere() {
        return genere;
    }
    
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(String autho) {
        this.author = autho;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCheckOutStatus() {
        return checkOutStatus;
    }

    public void setCheckOutStatus(boolean checkOutStatus) {
        this.checkOutStatus = checkOutStatus;
    }


    @Override
    public String toString(){
        return String.format("Book[id=%d, author=%s, title=%s, genere=%s, checkOutStatus=%s]",
        id, author, title, genere, checkOutStatus);
    }
    
}