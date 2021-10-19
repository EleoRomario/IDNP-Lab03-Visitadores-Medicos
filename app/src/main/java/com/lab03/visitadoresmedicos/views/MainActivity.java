package com.lab03.visitadoresmedicos.views;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.lab03.visitadoresmedicos.R;
import com.lab03.visitadoresmedicos.databinding.ActivityMainBinding;
import com.lab03.visitadoresmedicos.viewmodels.PatientViewModel;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Main";
    private PatientViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(PatientViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setActivity(this);
        binding.setViewModel(viewModel);
    }

    private ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    String firstName = result.getData().getStringExtra("firstName");
                    String lastName = result.getData().getStringExtra("lastName");
                    String dni = result.getData().getStringExtra("dni");
                    String email = result.getData().getStringExtra("email");
                    String address = result.getData().getStringExtra("address");
                    viewModel.registerUser(firstName, lastName, dni, email, address);
                }
            });

    private ActivityResultLauncher<Intent> mGetVisit = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    String SWeight = "";
                    String STemperature = "";
                    String SPressure = "";
                    String SSaturation = "";
                    double weight = 0;
                    int temperature = 0;
                    int pressure = 0;
                    int saturation = 0;
                    try {
                        SWeight = result.getData().getStringExtra("weight");
                        weight = Double.parseDouble(SWeight);
                    } catch (Exception e) {
                        Log.i("El usuario no ingreso todos los parametros", e.toString());
                    }
                    try {
                        STemperature = result.getData().getStringExtra("temperature");
                        temperature = Integer.parseInt(STemperature);
                    } catch (Exception e) {
                        Log.i("El usuario no ingreso todos los parametros", e.toString());
                    }
                    try {
                        SPressure = result.getData().getStringExtra("pressure");
                        pressure = Integer.parseInt(SPressure);
                    } catch (Exception e) {
                        Log.i("El usuario no ingreso todos los parametros", e.toString());
                    }
                    try {
                        SSaturation = result.getData().getStringExtra("saturation");
                        saturation = Integer.parseInt(SSaturation);
                    } catch (Exception e) {
                        Log.i("El usuario no ingreso todos los parametros", e.toString());
                    }

                    viewModel.recordVisit(weight, temperature, pressure, saturation);
                }
            });

    /**
     * TODO: replace logic to use startActivityForResult
     * use viewModel.registerPatient
     */
    public void goToPatientRegistrationForm() {
        Intent intent = new Intent(this, PatientFormActivity.class);
        mGetContent.launch(intent);
    }

    /**
     * TODO: replace logic to use startActivityForResult
     * use viewModel.recordVisit
     */
    public void goToVisitForm() {
        Intent intent = new Intent(this, VisitFormActivity.class);

        intent.putExtra("dni", viewModel.getDni().getValue().toString());
        mGetVisit.launch(intent);
    }

    public void sendEmail() {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setType("message/rfc822");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{viewModel.getEmail().getValue()});
        email.putExtra(Intent.EXTRA_SUBJECT, "Datos Personales");
        String cuerpo = "Nombre: " + viewModel.getFirstName().getValue() + "\n" +
                "Su peso es de: " + viewModel.getWeight().getValue() + "\n" +
                "Su temperatura es de: " + viewModel.getTemperature().getValue() + "\n" +
                "Su presion es de: " + viewModel.getPressure().getValue() + "\n" +
                "Su saturacion es de: " + viewModel.getSaturation().getValue();
        email.putExtra(Intent.EXTRA_TEXT, cuerpo);
        try {
            startActivity(Intent.createChooser(email, "Enviar email"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "No hay aplicacion de correo", Toast.LENGTH_SHORT).show();
        }
    }
}