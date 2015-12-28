package com.rasulov.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @RequestMapping(value = "/findContact", method = RequestMethod.GET)
    public ResponseEntity<String> findContact(@RequestParam("nameFilter")String regexText) {
        return ResponseEntity.ok("WORKS!  "+regexText);
    }


}
