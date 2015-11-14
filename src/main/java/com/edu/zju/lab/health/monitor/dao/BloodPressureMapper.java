package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodPressure;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodPressureMapper {
    @Insert("INSERT INTO  bloodpressure values(#{userID},#{timeStamp},#{systolic_pressure},#{diastolic_pressure},#{mean_pressure},#{pulse_rate},#{status})")
    void insert( BloodPressure bloodPressure);
}
