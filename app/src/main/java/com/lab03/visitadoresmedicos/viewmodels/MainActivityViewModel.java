package com.lab03.visitadoresmedicos.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Boolean> isUserRegistered;
    private MutableLiveData<Boolean> isLastVisitRecorded;

    public LiveData<Boolean> isLastVisitRecorded() {
        return isLastVisitRecorded;
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

    private MutableLiveData<String> weight;

    public LiveData<String> getWeight() {
        return weight;
    }

    private MutableLiveData<String> temperature;

    public LiveData<String> getTemperature() {
        return temperature;
    }

    private MutableLiveData<String> pressure;

    public LiveData<String> getPressure() {
        return pressure;
    }

    private MutableLiveData<String> saturation;

    public LiveData<String> getSaturation() {
        return saturation;
    }

    public MainActivityViewModel() {
        reset();
    }

    public void reset() {
        isUserRegistered = new MutableLiveData<>(false);
        isLastVisitRecorded = new MutableLiveData<>(false);

        firstName = new MutableLiveData<>("");
        lastName = new MutableLiveData<>("");
        dni = new MutableLiveData<>("");
        email = new MutableLiveData<>("");
        address = new MutableLiveData<>("");

        weight = new MutableLiveData<>("");
        temperature = new MutableLiveData<>("");
        pressure = new MutableLiveData<>("");
        saturation = new MutableLiveData<>("");
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

    public void recordVisit(String weight, String temperature, String pressure, String saturation) {
        if (isUserRegistered.getValue()) {
            this.weight.setValue(weight);
            this.temperature.setValue(temperature);
            this.pressure.setValue(pressure);
            this.saturation.setValue(saturation);

            this.isLastVisitRecorded.setValue(true);
        }
    }
}
