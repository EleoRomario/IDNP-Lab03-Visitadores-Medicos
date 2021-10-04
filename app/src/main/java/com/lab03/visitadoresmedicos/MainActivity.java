package com.lab03.visitadoresmedicos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.lab03.visitadoresmedicos.databinding.ActivityMainBinding;
import com.lab03.visitadoresmedicos.models.PatientViewModel;

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
                    viewModel.registerUser(firstName,"","","","");
                    Log.d(TAG, "mensajee" + firstName);
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
        Intent intent = new Intent(this, VisitForm.class);
        startActivity(intent);
    }

    /**
     * TODO: add logic to send the patient's data via email
     * use viewModels getters to access the patient's information
     */
    public void sendEmail(){
    }
}