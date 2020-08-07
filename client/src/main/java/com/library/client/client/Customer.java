package com.library.client.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private int numBooks;
    private List<Book> checkedOutBooks = new ArrayList<>();

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void saveJSON(File toFile, Customer customer) throws Exception {
        objectMapper.writeValue(toFile, customer);
    }
    public static Customer loadJSON(File fromFile) throws Exception{
        return objectMapper.readValue(fromFile, Customer.class);
    }
    protected Customer() {}

    public Customer(String firstName, String lastName, int numBooks, List<Book> cob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numBooks = numBooks;
        this.checkedOutBooks = cob;
    }

    @Override
    public String toString() {
        return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s', #books checked out= %d, books checked out= '&s']",
                id, firstName, lastName, numBooks, checkedOutBooks);
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
}