package com.contactFilter.repository;

import com.contactFilter.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ContactRepository extends CrudRepository<Contact, Long>, PagingAndSortingRepository<Contact, Long> {


}
