package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by MCH on 2015/11/13.
 */
public class BloodKetone {
    private int userID;
    private long timeStamp;
    private double blood_Ketone;
    private boolean status;

    public BloodKetone(){}

    public BloodKetone(int userID, long timeStamp, double bloodKetone, boolean status){
        this.userID = userID;
        this.timeStamp = timeStamp;
        this.blood_Ketone = bloodKetone;
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

    public double getBloodKetone() {
        return blood_Ketone;
    }

    public void setBloodKetone(double bloodKetone) {
        this.blood_Ketone = bloodKetone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
