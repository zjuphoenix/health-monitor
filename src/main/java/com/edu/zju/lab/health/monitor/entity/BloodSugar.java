package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by MCH on 2015/11/14.
 */
public class BloodSugar {
    private int userID;
    private long timeStamp;
    private double blood_Sugar;
    private boolean status;

    public BloodSugar(){}

    public BloodSugar(int userID, long timeStamp, double bloodSugar, boolean status){
        this.userID = userID;
        this.timeStamp = timeStamp;
        this.blood_Sugar = bloodSugar;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getBloodSugar() {
        return blood_Sugar;
    }

    public void setBloodSugar(double bloodSugar) {
        this.blood_Sugar = bloodSugar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
