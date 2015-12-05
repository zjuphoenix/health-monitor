package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.Ecg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2015/10/15.
 */
public interface EcgMapper {
    @Insert("INSERT INTO  ecg values(#{userID},#{timeStamp},#{breath_rate},#{heart_rate},#{status})")
    void insert( Ecg ecg);

    @Select("SELECT * FROM ecg WHERE userId = #{userId} order by timestamp DESC LIMIT #{offset},5")
    List<Ecg> getEcg(@Param("offset")int offset, @Param("userId")int id);

    @Select("SELECT count(*) FROM ecg")
    long getEcgCount();
}
