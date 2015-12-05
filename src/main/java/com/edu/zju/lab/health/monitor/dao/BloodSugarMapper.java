package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodSugar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodSugarMapper {
    @Insert("INSERT INTO  bloodsugar values(#{userID},#{timeStamp},#{bloodSugar},#{status})")
    void insert( BloodSugar bloodSugar);

    @Select("SELECT * FROM bloodsugar WHERE userId = #{userId} order by timestamp DESC LIMIT #{offset},5")
    List<BloodSugar> getBloodSugar(@Param("offset")int offset, @Param("userId")int id);

    @Select("SELECT count(*) FROM bloodsugar")
    long getBloodSugarCount();

    @Select("SELECT * FROM bloodsugar WHERE userId = #{userId} AND timestamp >= #{start_time} AND timestamp <= #{end_time} order by timestamp")
    List<BloodSugar> getBloodSugarByTime(@Param("start_time")long startTime, @Param("end_time")long endTime, @Param("userId")int id);
}
