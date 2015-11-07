package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by Administrator on 2015/10/16.
 */
public class BloodOxygen {
    private int pulse_rate;
    private int saturation;
    private int pulse_intensity;

    public int getPulse_rate() {
        return pulse_rate;
    }

    public void setPulse_rate(int pulse_rate) {
        this.pulse_rate = pulse_rate;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getPulse_intensity() {
        return pulse_intensity;
    }

    public void setPulse_intensity(int pulse_intensity) {
        this.pulse_intensity = pulse_intensity;
    }
}
