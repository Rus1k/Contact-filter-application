package com.contactFilter.service;

import com.contactFilter.model.Contact;
import com.contactFilter.repository.ContactRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Log
@Service
public class ContactFilterServiceImpl implements ContactFilterService {
    @Autowired
    private ContactRepository contactRepository;
    @Value(value = "${pageSize}")
    private int pageSize;

    @Override
    public Page<Contact> getContact(String filter, int pageNumber) {
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        Page<Contact> page = contactRepository.findAll(pageable);
        log.info("Page before filter: " + page.toString());

        Iterator<Contact> iterator = page.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().matches(filter)) {
                iterator.remove();
            }
        }
        log.info("Page after filter: " + page.toString());
        return page;
    }
}
