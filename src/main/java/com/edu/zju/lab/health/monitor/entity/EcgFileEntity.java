package com.edu.zju.lab.health.monitor.entity;

/**
 * Created by wuhaitao on 2015/11/14.
 */
public class EcgFileEntity {
    private long timeStamp;
    private int breathingrate;
    private int[] st;//3
    private int heartrate;
    private short[][] ecgs;//3*500
    private short[] flag;//500

    public short[] getFlag() {
        return flag;
    }

    public void setFlag(short[] flag) {
        this.flag = flag;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getBreathingrate() {
        return breathingrate;
    }

    public void setBreathingrate(int breathingrate) {
        this.breathingrate = breathingrate;
    }

    public int[] getSt() {
        return st;
    }

    public void setSt(int[] st) {
        this.st = st;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }

    public short[][] getEcgs() {
        return ecgs;
    }

    public void setEcgs(short[][] ecgs) {
        this.ecgs = ecgs;
    }
}
