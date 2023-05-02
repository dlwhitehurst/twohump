package com.dlwhitehurst.camel.service.impl;

import com.dlwhitehurst.camel.model.Contact;
import com.dlwhitehurst.camel.repository.ContactRepository;
import com.dlwhitehurst.camel.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> list;
        list = contactRepository.findAll();
        return list;
    }

    @Override
    public Contact addContact(Contact position) {
        return null;
    }

    @Override
    public Optional<Contact> getContact(Long id) {
        return Optional.empty();
    }

    @Override
    public Contact updateContact(Long id, Contact position) {
        return null;
    }

    @Override
    public void deleteContact(Long id) {

    }
}
