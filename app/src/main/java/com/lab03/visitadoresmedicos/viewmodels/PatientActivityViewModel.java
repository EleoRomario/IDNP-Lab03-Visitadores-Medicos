package com.lab03.visitadoresmedicos.viewmodels;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lab03.visitadoresmedicos.BR;
import com.lab03.visitadoresmedicos.models.Patient;

public class PatientActivityViewModel extends ViewModel {
    private static final String TAG ="PatientViewModel";

    private MutableLiveData<String> firstName;
    public LiveData<String> getFirstName() {
        return firstName;
    }

    private MutableLiveData<String> lastName;

    public LiveData<String> getLastName() {
        return lastName;
    }

    private MutableLiveData<String> dni;

    public LiveData<String> getDNI() {
        return dni;
    }

    private MutableLiveData<String> email;

    public LiveData<String> getEmail() {
        return email;
    }


    private MutableLiveData<String> address;
    public LiveData<String> getPatientAddress() {
        return address;
    }

}
