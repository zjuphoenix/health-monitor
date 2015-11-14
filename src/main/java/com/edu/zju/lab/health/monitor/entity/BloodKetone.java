package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by MCH on 2015/11/13.
 */
public class BloodKetone {
    private int userID;
    private String timeStamp;
    private float bloodKetone;
    private boolean status;

    public BloodKetone(int userID, String timeStamp, float bloodKetone, boolean status){
        this.userID = userID;
        this.timeStamp = timeStamp;
        this.bloodKetone = bloodKetone;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public float getBloodKetone() {
        return bloodKetone;
    }

    public void setBloodKetone(float bloodKetone) {
        this.bloodKetone = bloodKetone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
