package com.meetic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    @Column(name="us_Id")
    private int id;
    @Column(name="us_PhoneNum")
    private String phoneNum;
    @Column(name="us_Email")
    private String email;
    @Column(name="us_FirstName")
    private String firstName;
    @Column(name="us_LastName")
    private String lastName;
    @Column(name="us_Gender")
    private String gender;
    @Column(name="us_Cc")
    private String cc;
    @Column(name="us_TotalPoints")
    private int totalPoints;
    @Column(name="us_Adress")
    private String adress;

    public User() {}

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
    public String getCc() {
        return cc;
    }
    public int getTotalPoints() {
        return totalPoints;
    }
    public String getAdress() {
        return adress;
    }
}