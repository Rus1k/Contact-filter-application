package com.contactFilter.service;

import com.contactFilter.model.Contact;
import org.springframework.data.domain.Page;

public interface ContactFilterService {
   Page<Contact> getContact(String regexText, int pageNumber);
}
