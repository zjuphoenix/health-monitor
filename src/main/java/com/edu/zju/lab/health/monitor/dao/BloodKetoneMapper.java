package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.BloodKetone;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2015/10/18.
 */
public interface BloodKetoneMapper {
    @Insert("INSERT INTO  bloodketone values(#{userID},#{timeStamp},#{bloodKetone},#{status})")
    void insert( BloodKetone bloodKetone);
}
