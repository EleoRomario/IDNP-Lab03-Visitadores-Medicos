package com.lab03.visitadoresmedicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

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

        Button goToPatientButton = findViewById(R.id.go_to_patient_form_button);
        goToPatientButton.setOnClickListener((view) -> goToPatientRegistrationForm());
        Button goToVisitFormButton = findViewById(R.id.go_to_visit_form_button);
        goToVisitFormButton.setOnClickListener((view) -> goToVisitForm());
    }

    public void goToPatientRegistrationForm() {
        Intent intent = new Intent(this, PatientFormActivity.class);
        startActivity(intent);
    }

    public void goToVisitForm() {
        Intent intent = new Intent(this, VisitForm.class);
        startActivity(intent);
    }

    public void sendEmail(){
        Log.d(TAG, "Sending email");
    }
}