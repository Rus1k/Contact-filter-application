package com.contactFilter.repository;

import com.contactFilter.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ContactRepository extends JpaRepository<Contact, Integer > {
    
}
