package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodOxygen;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodOxygenMapper {
    @Insert("INSERT INTO  bloodoxygen values(#{userID},#{timeStamp},#{pulse_rate},#{saturation},#{pulse_intensity},#{status})")
    void insert( BloodOxygen bloodOxygen);

    @Select("SELECT * FROM bloodoxygen WHERE userId = #{userId} order by timestamp DESC LIMIT #{offset},5")
    List<BloodOxygen> getBloodOxygen(@Param("offset")int offset, @Param("userId")int id);

    @Select("SELECT count(*) FROM bloodoxygen")
    long getBloodOxygenCount();

    @Select("SELECT * FROM bloodoxygen WHERE userId = #{userId} AND timestamp >= #{start_time} AND timestamp <= #{end_time} order by timestamp")
    List<BloodOxygen> getBloodOxygenByTime(@Param("start_time")long startTime, @Param("end_time")long endTime, @Param("userId")int id);
}
