package com.meetic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Organizer")
public class Organizer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="or_Id")
    private int id;
    @Column(name="or_PhoneNum")
    private String phoneNum;
    @Column(name="or_Email")
    private String email;
    @Column(name="or_FirstName")
    private String firstName;
    @Column(name="or_LastName")
    private String lastName;
    @Column(name="or_Gender")
    private String gender;



    public Organizer() {}

    public int getId() {
        return id;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return gender;
    }

}