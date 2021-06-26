package com.meetic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Event_type")
public class EventType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="et_Id")
    private int id;
    @Column(name="et_Category")
    private String category;
    
    public EventType() {}

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

}