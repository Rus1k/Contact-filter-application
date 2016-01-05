package com.contactFilter.web;

import com.contactFilter.exception.InvalidPageNumberException;
import com.contactFilter.model.Contact;
import com.contactFilter.service.ContactFilterServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Log
@Controller
public class ContactFilterController {

    @Autowired
    private ContactFilterServiceImpl contactFilterService;


    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ResponseEntity<Page<Contact>> findContact(@RequestParam("nameFilter") String regex,
                                                     @RequestParam("pageNumber") int pageNumber) throws InvalidPageNumberException {
        Page<Contact> contact = contactFilterService.getContact(regex, pageNumber);
        if (pageNumber < 0) {
            throw new InvalidPageNumberException();
        }
        log.info("Name filter = " + regex + "; page number = " + pageNumber);
        log.info("Finishing result output: " + contact);
        return ResponseEntity.ok(contact);
    }

}
