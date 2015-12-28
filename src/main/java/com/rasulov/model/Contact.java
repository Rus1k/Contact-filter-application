package com.rasulov.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    private int id;

    private String name;

}
