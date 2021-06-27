package com.meetic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="event_status")
public class EventStatus {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="es_Id")
    private int id;
    @Column(name="es_Status")
    private String status;

    public EventStatus() {}

    public int getId() {
        return id;
    }
    public String getStatus() {
        return status;
    }


}