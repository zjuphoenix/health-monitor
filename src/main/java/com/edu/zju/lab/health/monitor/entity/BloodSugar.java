package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by MCH on 2015/11/14.
 */
public class BloodSugar {
    private int userID;
    private String timeStamp;
    private float bloodSugar;
    private boolean status;

    public BloodSugar(int userID, String timeStamp, float bloodKetone, boolean status){
        this.userID = userID;
        this.timeStamp = timeStamp;
        this.bloodSugar = bloodKetone;
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

    public float getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(float bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
