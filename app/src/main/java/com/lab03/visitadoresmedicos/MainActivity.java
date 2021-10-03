package com.lab03.visitadoresmedicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.lab03.visitadoresmedicos.databinding.ActivityMainBinding;
import com.lab03.visitadoresmedicos.models.PatientViewModel;

public class MainActivity extends AppCompatActivity {
    private PatientViewModel viewModel;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(PatientViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setActivity(this);
        binding.setViewModel(viewModel);
    }

    /**
     * TODO: replace logic to use startActivityForResult
     * use viewModel.registerPatient
     */
    public void goToPatientRegistrationForm() {
        Intent intent = new Intent(this, PatientFormActivity.class);
        viewModel.registerUser("", "", "", "", "");
        Log.d(TAG, viewModel.isLastVisitRecorded().getValue().toString());
        startActivity(intent);
    }

    /**
     * TODO: replace logic to use startActivityForResult
     * use viewModel.recordVisit
     */
    public void goToVisitForm() {
        Intent intent = new Intent(this, VisitForm.class);
        viewModel.recordVisit(0.0, 0, 0, 0);
        startActivity(intent);
    }

    /**
     * TODO: add logic to send the patient's data via email
     * use viewModels getters to access the patient's information
     */
    public void sendEmail(){
        Log.d(TAG, "Sending email");
    }
}