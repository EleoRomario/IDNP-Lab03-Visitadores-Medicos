package com.lab03.visitadoresmedicos.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Patient {
    private boolean isLastVisitRecorded;
    private boolean isUserRegistered;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String address;

    public boolean isLastVisitRecorded() {
        return isLastVisitRecorded;
    }

    public void setLastVisitRecorded(boolean lastVisitRecorded) {
        isLastVisitRecorded = lastVisitRecorded;
    }

    public boolean isUserRegistered() {
        return isUserRegistered;
    }

    public void setUserRegistered(boolean userRegistered) {
        isUserRegistered = userRegistered;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
