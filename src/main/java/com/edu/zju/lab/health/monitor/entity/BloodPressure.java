package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by Administrator on 2015/10/16.
 */
public class BloodPressure {
    private int systolic_pressure;
    private int diastolic_pressure;
    private int mean_pressure;
    private int pulse_rate;

    public int getSystolic_pressure() {
        return systolic_pressure;
    }

    public void setSystolic_pressure(int systolic_pressure) {
        this.systolic_pressure = systolic_pressure;
    }

    public int getDiastolic_pressure() {
        return diastolic_pressure;
    }

    public void setDiastolic_pressure(int diastolic_pressure) {
        this.diastolic_pressure = diastolic_pressure;
    }

    public int getMean_pressure() {
        return mean_pressure;
    }

    public void setMean_pressure(int mean_pressure) {
        this.mean_pressure = mean_pressure;
    }

    public int getPulse_rate() {
        return pulse_rate;
    }

    public void setPulse_rate(int pulse_rate) {
        this.pulse_rate = pulse_rate;
    }
}
