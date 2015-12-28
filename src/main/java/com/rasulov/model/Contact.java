package com.rasulov.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    private int id;

    private String name;

}
