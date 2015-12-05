package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodKetone;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodKetoneMapper {
    @Insert("INSERT INTO  bloodketone values(#{userID},#{timeStamp},#{bloodKetone},#{status})")
    void insert( BloodKetone bloodKetone);

    @Select("SELECT * FROM bloodketone WHERE userId = #{userId} order by timestamp DESC LIMIT #{offset},5")
    List<BloodKetone> getBloodKetone(@Param("offset")int offset, @Param("userId")int id);

    @Select("SELECT count(*) FROM bloodketone")
    long getBloodKetoneCount();

    @Select("SELECT * FROM bloodketone WHERE userId = #{userId} AND timestamp >= #{start_time} AND timestamp <= #{end_time} order by timestamp")
    List<BloodKetone> getBloodKetoneByTime(@Param("start_time")long startTime, @Param("end_time")long endTime, @Param("userId")int id);
}
