package com.librarydata.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity <List<Customer>> getAllCustomers() {
        try{
            List<Customer> customers = new ArrayList<Customer>();
            customerRepository.findAll()
            .forEach(customers::add);
            if(customers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }    
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity <Customer> getCustomer(Long id) {
        Optional <Customer> custOptional = customerRepository.findById(id); 
        if(custOptional.isPresent()) {
            return new ResponseEntity<>(custOptional.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    public ResponseEntity<List <Customer>> getAllCustomerByLastName(String lastName) {
        try {
            List<Customer> customers = new ArrayList<>();
            customerRepository.findAllByLastName(lastName).
            forEach(customers::add);
            if(customers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    catch(Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        try{
           Customer savedCustomer = customerRepository.save(customer);
           return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<Customer> updateCustomer(Customer customer, Long id) {
        Optional<Customer> custOptional = customerRepository.findById(id);
        if(custOptional.isPresent()){
            return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Customer> updateCustomerByLastName(Customer customer, String lastName) {
        Optional <Customer> custOptional = customerRepository.findByLastName(lastName); 
        if(custOptional.isPresent()) {
            return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	public ResponseEntity<HttpStatus> deleteCustomer(Long id) {
        try{
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
	}
    /*
	public ResponseEntity<String> bookCheckout(Customer customer, Book book) {
        List<Book> bookList = new ArrayList<>();    
        if(book.getCheckOutStatus()) {
                return new ResponseEntity<>("Book already checked out",HttpStatus.BAD_REQUEST);
            }
            else{
                try{
                    bookList.add(book);
                    customerRepository.setCheckedOutBooks(bookList);
                    book.setCheckOutStatus(true);
                    return new ResponseEntity<>("Book succsefully checked out",HttpStatus.OK);
                }

                 catch(Exception e){
                     return new ResponseEntity<>("An Error Occurred", HttpStatus.EXPECTATION_FAILED);
                 }
        }
    }
    */
}
