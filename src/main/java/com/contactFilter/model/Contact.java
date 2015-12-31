package com.contactFilter.model;


import lombok.Data;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    private long id;

    private String name;

}
