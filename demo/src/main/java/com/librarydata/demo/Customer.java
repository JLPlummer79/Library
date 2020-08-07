package com.librarydata.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int numBooks;
    @OneToMany(
        mappedBy = "customer",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Book> checkedOutBooks = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String firstName, String lastName, int numBooks, List<Book> cob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numBooks = numBooks;
        this.checkedOutBooks = cob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumBooks() {
        return numBooks;
    }
    public void setNumBooks(int numBooks) {
        this.numBooks = numBooks;
    }
    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }
    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }
    @Override
    public String toString() {
        return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s', #books checked out= %d, books checked out='%s']",
                id, firstName, lastName, numBooks, checkedOutBooks);
    }

}