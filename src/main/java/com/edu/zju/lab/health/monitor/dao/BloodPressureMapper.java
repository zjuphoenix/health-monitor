package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodPressure;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodPressureMapper {
    @Insert("INSERT INTO  bloodpressure values(#{userID},#{timeStamp},#{systolic_pressure},#{diastolic_pressure},#{mean_pressure},#{pulse_rate},#{status})")
    void insert( BloodPressure bloodPressure);

    @Select("SELECT * FROM bloodpressure WHERE userId = #{userId} order by timestamp DESC LIMIT #{offset},5")
    List<BloodPressure> getBloodPressure(@Param("offset")int offset, @Param("userId")int id);

    @Select("SELECT count(*) FROM bloodpressure")
    long getBloodPressureCount();

    @Select("SELECT * FROM bloodpressure WHERE userId = #{userId} AND timestamp >= #{start_time} AND timestamp <= #{end_time} order by timestamp")
    List<BloodPressure> getBloodPressureByTime(@Param("start_time")long startTime, @Param("end_time")long endTime, @Param("userId")int id);
}
