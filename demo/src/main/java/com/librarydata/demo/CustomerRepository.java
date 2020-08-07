package com.librarydata.demo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Remove @RepositoryRestResource below to disable auto REST api:
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
     public void deleteById(Long id);
     
     public Optional<Customer> findByLastName(String lastName);

     public List<Customer> findAllByLastName(String lastName);

     //public void setCheckedOutBooks(List<Book> books);

    public List<Book> getByCheckedOutBooks(Long id);
    
}