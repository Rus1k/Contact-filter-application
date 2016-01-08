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

    @Override
    public List<Contact> getContact(String filter) {
        List<Contact> resultList = new ArrayList<>();

        long countContacts = contactRepository.count();

        long totalPages = getTotalPages(countContacts);

        log.info("Total contacts: "
                + countContacts + "; regex: "
                + filter + "; page size: "
                + pageSize + "; total pages : "
                + totalPages + ";");

        for (int i = 0; i < totalPages; i++) {

            Pageable pageable = new PageRequest(i, pageSize);
            Page<Contact> page = contactRepository.findAll(pageable);
            resultList.addAll(getFilteredList(filter, page.getContent()));
            log.info("ResultList after filter " + i + " page :" + resultList);
        }
        return resultList;
    }

    private long getTotalPages(long countContacts) {
        long totalPages;
        if (countContacts % pageSize != 0) {
            totalPages = countContacts / pageSize + 1;
        } else {
            totalPages = countContacts / pageSize;
        }
        return totalPages;
    }

    private List<Contact> getFilteredList(String filter, List<Contact> list) {
        return list.stream().filter(s -> !s.getName().matches(filter)).collect(Collectors.toList());
    }
}
