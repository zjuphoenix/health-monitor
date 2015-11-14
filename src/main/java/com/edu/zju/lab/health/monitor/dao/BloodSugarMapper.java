package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodSugar;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodSugarMapper {
    @Insert("INSERT INTO  bloodsugar values(#{userID},#{timeStamp},#{bloodSugar},#{status})")
    void insert( BloodSugar bloodSugar);
}
