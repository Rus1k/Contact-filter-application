package com.rasulov.service;

import com.rasulov.model.Contact;
import com.rasulov.repository.ContactRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
@Log
@Service
public class ContactFilterServiceImpl implements ContactFilterService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContact(String regexText) {
        List<Contact> list = contactRepository.findAll();
        log.info("get all contacts from db");
        Iterator<Contact> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().matches(regexText)) {
                iterator.remove();
            }
        }
        log.info("return filtered contacts");
        return list;
    }
}
