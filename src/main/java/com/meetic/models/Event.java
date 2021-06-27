package com.meetic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Event")
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="ev_Id")
    private int id;
    @Column(name="ev_Capacity")
    private int capacity;
    @Column(name="ev_Name")
    private String name;
    @Column(name="ev_Description")
    private String description;
    @Column(name="ev_EvType_Id")
    private int categoryID;

    public Event() {}

    public int getId() {
        return id;
    }
    public int getCapacity() {
        return capacity;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getCategoryID() {
        return categoryID;
    }

}
