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
//handles the librian/customer request operations
//things a single customer should not be able to do
public class Librarian_CustomerController {
   
    @Autowired
    CustomerService customerService;

    @RequestMapping("/librarian/accounts")
    public String home() {
        return "/librarian//accounts/name: all customers <br/>"+ System.lineSeparator()+
        "/librarian//accounts/{id}: search customer by id <br/>"+ System.lineSeparator()+
        "/librarian//accounts/add/: add new customer <br/>"+ System.lineSeparator()+
        "/librarian/accounts/update/: update customer attributes <br/>"+ System.lineSeparator()+
        "/librarian/accounts/delete/: delete customer <br/>"+ System.lineSeparator()+
        "/librarian/accounts/name/{lastName}: search customer(s) by last name <br/> "+System.lineSeparator()+
        "/librarian/accounts/name/{lastName}: update customer (only one) by name<br/>"+System.lineSeparator();
    }

    //getAll customers
    @RequestMapping("/librarian/accounts/name")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping("/librarian/accounts/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
    
    //get Customer by last name
    @RequestMapping("/librarian/accounts/name/{lastName}")
    public ResponseEntity<List <Customer>> getCustomerByName(@PathVariable String lastName) {
        return customerService.getAllCustomerByLastName(lastName);
    }

    //addCustomer
    @PostMapping("/librarian/accounts/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
    //updateCustomer by id
    @PutMapping("/librarian/accounts/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id ) {
        return customerService.updateCustomer(customer, id);
    }
    //add updateCustomer by name
    @PutMapping("/librarian/accounts/name/{lastName}")
    public ResponseEntity<Customer> updateCustomer(@ RequestBody Customer customer, @PathVariable String lastName) {
        return customerService.updateCustomerByLastName(customer, lastName);
    }

     //deleteCustomer
     @DeleteMapping("/librarian/accounts/delete/{id}")
     public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
         return customerService.deleteCustomer(id);
     }
     /*
     //update checked out book list
     @PostMapping("librarian/accounts/checkout/")
    public ResponseEntity<String> bookCheckout(@RequestBody Customer customer, @RequestBody Book book) {
        return customerService.bookCheckout(customer, book);
    }
     */

}