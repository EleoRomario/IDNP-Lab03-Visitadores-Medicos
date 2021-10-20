package com.lab03.visitadoresmedicos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.lab03.visitadoresmedicos.R;
import com.lab03.visitadoresmedicos.databinding.ActivityPatientFormBinding;
import com.lab03.visitadoresmedicos.viewmodels.PatientActivityViewModel;

public class PatientFormActivity extends AppCompatActivity {
    private final String TAG = "PatientActivity";
    private PatientActivityViewModel viewModel;

    TextInputEditText firstName, lastName, dni, email, address;
    String sfName, slName, sdni, semail, saddress;
    TextInputLayout dnilayout, emaillayout;

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

        dnilayout=findViewById(R.id.dni_text_field);
        emaillayout=findViewById(R.id.email_text_field);
    }

    private int validar(){

        int cont=0;
        String email = emaillayout.getEditText().getText().toString();
        String dni = dnilayout.getEditText().getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emaillayout.setErrorEnabled(false);
            cont++;
        }else if(email.isEmpty()){
            emaillayout.setError("Ingrese un email");
        }else{
            emaillayout.setError("Email inválido");
        }

        if(dni.length()==8){
            dnilayout.setErrorEnabled(false);
            cont++;
        }else if(dni.isEmpty()){
            dnilayout.setError("Ingrese un número de dni");
        }else{
            dnilayout.setError("Número de digitos inválido");
        }
        return cont;
    }

    public void registerUser() {

        if(validar()==2){
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

    }
    //finish

}