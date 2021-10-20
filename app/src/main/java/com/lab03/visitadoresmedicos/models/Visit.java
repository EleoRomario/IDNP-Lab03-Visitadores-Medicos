package com.lab03.visitadoresmedicos.models;

import com.google.android.material.textfield.TextInputEditText;
import com.lab03.visitadoresmedicos.R;

public class Visit {
    private String dni;
    private String Weight;
    private String temperature;
    private String pressure;
    private String saturation;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSaturation() {
        return saturation;
    }

    public void setSaturation(String saturation) {
        this.saturation = saturation;
    }
}
