package com.dlwhitehurst.camel.service;

import com.dlwhitehurst.camel.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getAllContacts();

    Contact addContact(Contact position);

    Optional<Contact> getContact(Long id);

    Contact updateContact(Long id, Contact position);

    void deleteContact(Long id);
    
}
