package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by Administrator on 2015/10/16.
 */
public class Ecg {
    private int breath_rate;
    private int heart_rate;

    public int getBreath_rate() {
        return breath_rate;
    }

    public void setBreath_rate(int breath_rate) {
        this.breath_rate = breath_rate;
    }

    public int getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(int heart_rate) {
        this.heart_rate = heart_rate;
    }
}
