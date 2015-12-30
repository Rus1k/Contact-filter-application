package com.contactFilter.repository;

import com.contactFilter.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ContactRepository extends JpaRepository<Contact, Long >, PagingAndSortingRepository<Contact, Long > {

    
}
