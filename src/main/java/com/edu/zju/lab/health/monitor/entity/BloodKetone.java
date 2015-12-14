package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by MCH on 2015/11/13.
 */
public class BloodKetone {
    private int userID;
    private long timeStamp;
    private double blood_ketone;
    private boolean status;

    public BloodKetone(){}

    public BloodKetone(int userID, long timeStamp, double blood_ketone, boolean status){
        this.userID = userID;
        this.timeStamp = timeStamp;
        this.blood_ketone = blood_ketone;
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

    public double getBlood_ketone() {
        return blood_ketone;
    }

    public void setBlood_ketone(double blood_ketone) {
        this.blood_ketone = blood_ketone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
