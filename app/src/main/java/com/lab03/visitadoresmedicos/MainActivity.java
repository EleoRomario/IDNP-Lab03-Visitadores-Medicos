package com.lab03.visitadoresmedicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goToPatientButton = findViewById(R.id.go_to_patient_form_button);
        goToPatientButton.setOnClickListener((view) -> goToPatientRegistrationForm());
        Button goToVisitFormButton = findViewById(R.id.go_to_visit_form_button);
        goToVisitFormButton.setOnClickListener((view) -> goToVisitForm());
    }

    private void goToPatientRegistrationForm() {
        Intent intent = new Intent(this, PatientFormActivity.class);
        startActivity(intent);
    }

    private void goToVisitForm() {
        Intent intent = new Intent(this, VisitForm.class);
        startActivity(intent);
    }
}