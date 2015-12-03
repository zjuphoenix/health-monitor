package com.edu.zju.lab.health.monitor.utils;

/**
 * Created by MCH on 2015/12/3.
 */
public class ServiceException extends RuntimeException{
    public ServiceException() {
        super();
    }

    public ServiceException(String msg, Throwable clause) {
        super(msg, clause);
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Throwable clause) {
        super(clause);
    }
}
