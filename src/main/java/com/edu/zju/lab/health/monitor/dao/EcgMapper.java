package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.Ecg;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2015/10/15.
 */
public interface EcgMapper {
    @Insert("INSERT INTO  ecg values(#{userID},#{timeStamp},#{breath_rate},#{heart_rate},#{status})")
    void insert( Ecg ecg);
}
