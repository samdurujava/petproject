package com.example.petproject;

import org.springframework.lang.NonNull;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import java.util.Date;


@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String petname;

    @NonNull
    private String color;

    @NonNull
    private Date dateLost;

    @NonNull
    private String contactPhone;

    @NotNull
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDateLost() {
        return dateLost;
    }

    public void setDateLost(Date dateLost) {
        this.dateLost = dateLost;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
