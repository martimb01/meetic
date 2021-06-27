package com.meetic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Gifts")
public class Gifts {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="gi_Id")
    private int id;
    @Column(name="gi_Name")
    private String name;
    @Column(name="gi_Price")
    private int price;
    
    public Gifts() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


}