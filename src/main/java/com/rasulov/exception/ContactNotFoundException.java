package com.rasulov.exception;

/**
 * Created by ruslan on 27.12.2015.
 */
public class ContactNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Contact not found exception";
    }
}
