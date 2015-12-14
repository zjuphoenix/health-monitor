package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by MCH on 2015/11/14.
 */
public class BloodSugar {
    private int userID;
    private long timeStamp;
    private double blood_sugar;
    private boolean status;

    public BloodSugar(){}

    public BloodSugar(int userID, long timeStamp, double blood_sugar, boolean status){
        this.userID = userID;
        this.timeStamp = timeStamp;
        this.blood_sugar = blood_sugar;
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

    public double getBlood_sugar() {
        return blood_sugar;
    }

    public void setBlood_sugar(double blood_sugar) {
        this.blood_sugar = blood_sugar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
