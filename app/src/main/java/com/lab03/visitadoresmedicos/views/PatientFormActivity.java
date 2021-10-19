package com.lab03.visitadoresmedicos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;
import com.lab03.visitadoresmedicos.R;
import com.lab03.visitadoresmedicos.databinding.ActivityPatientFormBinding;

public class PatientFormActivity extends AppCompatActivity {
    private final String TAG = "PatientActivity";
    private PatientActivityViewModel viewModel;

    TextInputEditText firstName, lastName, dni, email, address;
    String sfName, slName, sdni, semail, saddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPatientFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_patient_form);
        binding.setPatientFormActivity(this);

        firstName = (TextInputEditText) findViewById(R.id.first_names_edit_text);
        lastName = (TextInputEditText) findViewById(R.id.last_names_edit_text);
        dni = (TextInputEditText) findViewById(R.id.dni_edit_text);
        email = (TextInputEditText) findViewById(R.id.email_edit_text);
        address = (TextInputEditText) findViewById(R.id.address_edit_text);
    }

    public void registerUser() {
        sfName = firstName.getText().toString();
        slName = lastName.getText().toString();
        sdni = dni.getText().toString();
        semail = email.getText().toString();
        saddress = address.getText().toString();

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("firstName", sfName);
        i.putExtra("lastName", slName);
        i.putExtra("dni", sdni);
        i.putExtra("email", semail);
        i.putExtra("address", saddress);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
    //finish

}