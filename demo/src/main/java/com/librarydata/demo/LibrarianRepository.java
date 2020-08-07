package com.librarydata.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends CrudRepository<Librarian, Long> {

}