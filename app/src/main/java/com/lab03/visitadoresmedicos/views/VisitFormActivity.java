package com.lab03.visitadoresmedicos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.google.android.material.textfield.TextInputEditText;
import com.lab03.visitadoresmedicos.R;
import com.lab03.visitadoresmedicos.databinding.ActivityVisitFormBinding;
import com.lab03.visitadoresmedicos.viewmodels.VisitActivityViewModel2;

public class VisitFormActivity extends AppCompatActivity{
    private final String TAG = "VisitActivity";
    private VisitActivityViewModel2 viewModel;

  TextInputEditText dni, weight, temperature, pressure, saturation;
    String sfDni, slWeight, sdTemparature, semPressure,saSaturation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVisitFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_visit_form);
        binding.setVisitFormActivity(this);

        dni=(TextInputEditText) findViewById(R.id.dni_edit_text);
        dni.setText(getIntent().getStringExtra("dni"));
        weight=(TextInputEditText) findViewById(R.id.weight_edit_text);
        temperature=(TextInputEditText) findViewById(R.id.temperature_edit_text);
        pressure=(TextInputEditText) findViewById(R.id.pressure_edit_text);
        saturation=(TextInputEditText) findViewById(R.id.saturation_edit_text);
    }

    public void saveVisit(){
        sfDni = dni.getText().toString();
        slWeight = weight.getText().toString();
        sdTemparature = temperature.getText().toString();
        semPressure= pressure.getText().toString();
        saSaturation= saturation.getText().toString();

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("dni", sfDni);
        i.putExtra("weight", slWeight);
        i.putExtra("temperature", sdTemparature);
        i.putExtra("pressure", semPressure);
        i.putExtra("saturation", saSaturation);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}