package com.rasulov.service;

import com.rasulov.model.Contact;

import java.util.List;

public interface ContactFilterService {
   List<Contact> getContact(String regexText);
}
