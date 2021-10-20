package com.lab03.visitadoresmedicos.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VisitActivityViewModel2 extends ViewModel {
        private static final String TAG ="VisitViewModel";

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

}
