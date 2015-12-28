package com.rasulov.web;

import com.rasulov.model.Contact;
import com.rasulov.service.ContactFilterServiceImpl;
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
public class MyController {
    @Autowired
    private ContactFilterServiceImpl contactFilterService;
    @RequestMapping(value = "/findContact", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> findContact(@RequestParam("nameFilter") String regexText) {
        List <Contact> list = contactFilterService.getContact(regexText);
        log.info("Filtered list of contacts");
        return ResponseEntity.ok(list);
    }

}
