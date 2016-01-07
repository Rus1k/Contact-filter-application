package com.contactFilter.service;

import com.contactFilter.model.Contact;

import java.util.List;

public interface ContactFilterService {
    List<Contact> getContact(String regexText);
}
