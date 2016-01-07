package com.contactFilter.service;


import com.contactFilter.model.Contact;
import com.contactFilter.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactFilterServiceImplTest {
    @Mock
    private ContactRepository contactRepository;
    @InjectMocks
    private ContactFilterServiceImpl contactFilterService;

    private int pageSize = 100;

    private Contact din = Contact.builder().id(1).name("Din").build();
    private Contact leonard = Contact.builder().id(2).name("Leonard").build();
    private Contact sheldon = Contact.builder().id(3).name("Sheldon").build();
    private Contact tirion = Contact.builder().id(4).name("Tirion").build();
    private Contact din1 = Contact.builder().id(5).name("Din").build();


    @Test
    public void testGetContactResultVoid() throws Exception {
        List<Contact> list = new LinkedList<>();
        list.add(Contact.builder().id(1).name("Vadim").build());
        Page<Contact> page = new PageImpl<>(list);
        Pageable pageable = new PageRequest(0, pageSize);
        when(contactRepository.findAll(pageable)).thenReturn(page);
        List<Contact> actualResult = contactFilterService.getContact("Vadim");
        assertEquals(new PageImpl<>(Collections.emptyList()).getContent(), actualResult);
    }

    @Test
    public void testGetContactFilteredByFirstCharacter() throws Exception {

        List<Contact> list = new ArrayList<Contact>() {{
            add(leonard);
            add(sheldon);
            add(tirion);
            add(din);
        }};

        List<Contact> expectedResult = new ArrayList<Contact>() {{
            add(leonard);
            add(sheldon);
            add(tirion);
        }};

        Page<Contact> page = new PageImpl<>(list);
        Pageable pageable = new PageRequest(0, pageSize);
        when(contactRepository.findAll(pageable)).thenReturn(page);
        List<Contact> actualResult = contactFilterService.getContact("\\b(D)\\S*");
        assertEquals(new PageImpl<>(expectedResult).getContent(), actualResult);
    }

    @Test
    public void testGetContactFilteredByFullName() throws Exception {
        List<Contact> list = new ArrayList<Contact>() {{
            add(din);
            add(leonard);
            add(sheldon);
            add(tirion);
            add(din1);
        }};
        List<Contact> expectedResult = new ArrayList<Contact>() {{
            add(leonard);
            add(sheldon);
            add(tirion);
        }};
        Page<Contact> page = new PageImpl<>(list);
        Pageable pageable = new PageRequest(0, pageSize);
        when(contactRepository.findAll(pageable)).thenReturn(page);
        List<Contact> actualResult = contactFilterService.getContact("Din");
        assertEquals(new PageImpl<>(expectedResult).getContent(), actualResult);
    }


}