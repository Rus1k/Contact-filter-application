package com.rasulov.repository;

import com.rasulov.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ContactRepository extends JpaRepository<Contact, Integer > {
    
}
