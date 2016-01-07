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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class ContactFilterServiceImpl implements ContactFilterService {
    @Autowired
    private ContactRepository contactRepository;
    @Value(value = "${pageSize}")
    private int pageSize = 10;
    List<Contact> list = null;
    List<Contact> resultList = new ArrayList<>();

    void filterList(String regex) {
        log.info("__________ BEFORE FILTER __________ " + list);
        list = list.stream().filter(s -> !s.getName().matches(regex)).collect(Collectors.toList());
        log.info("__________ AFTER FILTER __________ " + list);
        resultList.addAll(list);
    }

    @Override
    public List<Contact> getContact(String filter) {
        long countContacts = contactRepository.count();
        log.info("__________ QUANTITY ELEMENTS __________ :" + countContacts);
        log.info("__________ REGEX TEXT __________ :" + filter);
        log.info("__________ PAGE SIZE __________ " + pageSize);

        for (int i = 0; i < countContacts / pageSize; i++) {
            Pageable pageable = new PageRequest(i, pageSize);
            Page<Contact> page = contactRepository.findAll(pageable);
            list = page.getContent();
            filterList(filter);
        }

        log.info(" __________ RESULT __________ " + resultList);
        return resultList;
    }
}
