package com.librarydata.demo;

import javax.swing.plaf.metal.MetalBorders.ButtonBorder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    String border = System.lineSeparator() + "<br/>========================================================";
    String search = System.lineSeparator() + "<br/>/search/: display all books";
    String book = System.lineSeparator() + "<br/>/books/: display catalog";
    String accounts_id = System.lineSeparator() + "<br/>/accounts/: card holder actions";
    String accounts_name = System.lineSeparator() + "<br/>/accounts/name/{Last Name}: login by name";
    String librarian_accounts = System.lineSeparator() + "<br/>/librarian/: librarian actions";
    String librarian_accounts_id = System.lineSeparator() + "<br/>/librarian/accounts/{id}";
    String librarian_accounts_name = System.lineSeparator() + "<br/>/librarian/accounts/name/{last}";
    String librarian_books = System.lineSeparator() + "<br/>/librarian/search/id or title";
    String accounts_checkout = "<br/>/accounts/account id/checkout/{book} for checkout";
    
    @GetMapping("/")
    public String homeMessage() {
        return  "Ankmorpork Library Server"+border+book+search+accounts_id+
        librarian_accounts+border;
    }    
    
    @GetMapping("/accounts/")
    public String accountsHomeMessage() {
        return "Welcome to the Ankmorpork Library!<br/>"+System.lineSeparator()+border+accounts_id+
        accounts_name+accounts_checkout+border;
    }


    @RequestMapping("/librarian/")
    public String librarianHome() {
        return "Welcome to the Ankmorpork Library!<br/>" +border+
        System.lineSeparator()+"/librarian<br/>"+
        System.lineSeparator()+"/librarian/accounts: customer accounts<br/>"+
        System.lineSeparator()+"/librarian/book : book transactions<br/>"+border;
    }

}