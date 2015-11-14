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

    @Select("SELECT * FROM bloodketone order by timestamp")
    List<BloodKetone> getBloodKetone();
}
