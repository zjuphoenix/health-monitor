package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodOxygen;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodOxygenMapper {
    @Insert("INSERT INTO  bloodoxygen values(#{userID},#{timeStamp},#{pulse_rate},#{saturation},#{pulse_intensity},#{status})")
    void insert( BloodOxygen bloodOxygen);

    @Select("SELECT * FROM bloodoxygen order by timestamp")
    List<BloodOxygen> getBloodOxygen();
}
