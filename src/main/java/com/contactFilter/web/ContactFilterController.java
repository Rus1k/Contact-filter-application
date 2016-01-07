package com.contactFilter.web;

import com.contactFilter.model.Contact;
import com.contactFilter.service.ContactFilterServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log
@Controller
public class ContactFilterController {

    @Autowired
    private ContactFilterServiceImpl contactFilterService;


    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> findContact(@RequestParam("nameFilter") String regex) {

        List<Contact> contact = contactFilterService.getContact(regex);

        log.info("Finishing result output: " + contact);
        return ResponseEntity.ok(contact);
    }

}
