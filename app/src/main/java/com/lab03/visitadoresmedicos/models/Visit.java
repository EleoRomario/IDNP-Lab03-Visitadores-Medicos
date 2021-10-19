package com.lab03.visitadoresmedicos.models;

import com.google.android.material.textfield.TextInputEditText;
import com.lab03.visitadoresmedicos.R;

public class Visit {
    private String dni;
    private double Weight;
    private int temperature;
    private int pressure;
    private int saturation;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }
}
