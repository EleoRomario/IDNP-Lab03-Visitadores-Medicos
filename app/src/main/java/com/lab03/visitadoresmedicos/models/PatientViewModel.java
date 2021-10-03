package com.lab03.visitadoresmedicos.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class PatientViewModel extends ViewModel {
    private MutableLiveData<Boolean> isUserRegistered;
    private MutableLiveData<Boolean> isLastVisitRecorded;

    public LiveData<Boolean> isLastVisitRecorded() {
        return isUserRegistered;
    }

    public LiveData<Boolean> getIsUserRegistered() {
        return isUserRegistered;
    }

    private MutableLiveData<String> firstName;

    public LiveData<String> getFirstName() {
        return firstName;
    }

    private MutableLiveData<String> lastName;

    public LiveData<String> getLastName() {
        return lastName;
    }

    private MutableLiveData<String> dni;

    public LiveData<String> getDni() {
        return dni;
    }

    private MutableLiveData<String> email;

    public LiveData<String> getEmail() {
        return email;
    }


    private MutableLiveData<String> address;

    public LiveData<String> getAddress() {
        return address;
    }

    private MutableLiveData<Double> weight;

    public LiveData<Double> getWeight() {
        return weight;
    }

    private MutableLiveData<Integer> temperature;

    public LiveData<Integer> getTemperature() {
        return temperature;
    }

    private MutableLiveData<Integer> pressure;

    public LiveData<Integer> getPressure() {
        return pressure;
    }

    private MutableLiveData<Integer> saturation;

    public LiveData<Integer> getSaturation() {
        return saturation;
    }

    public PatientViewModel() {
        reset();
    }

    public void reset() {
        isUserRegistered = new MutableLiveData<>(false);
        isLastVisitRecorded = new MutableLiveData<>(false);

        firstName = new MutableLiveData<>("");
        lastName = new MutableLiveData<>("");
        dni = new MutableLiveData<>("");
        address = new MutableLiveData<>("");

        weight = new MutableLiveData<>(0.0);
        temperature = new MutableLiveData<>(0);
        pressure = new MutableLiveData<>(0);
        saturation = new MutableLiveData<>(0);
    }

    public void registerUser(String firstName, String lastName, String dni, String email, String address) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.dni.setValue(dni);
        this.email.setValue(email);
        this.address.setValue(address);

        this.isUserRegistered.setValue(true);
        this.isLastVisitRecorded.setValue(false);
    }

    public void recordVisit(double weight, int temperature, int pressure, int saturation) {
        if (isUserRegistered.getValue()) {
            this.weight.setValue(weight);
            this.temperature.setValue(temperature);
            this.pressure.setValue(pressure);
            this.saturation.setValue(saturation);

            this.isLastVisitRecorded.setValue(true);
        }
    }
}
