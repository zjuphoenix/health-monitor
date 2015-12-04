package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2015/10/14.
 */
public interface UserMapper {
    @Insert("INSERT INTO  user (username,  password, tel) values(#{username},#{password},#{tel})")
    void insert( User user);

    @Select("SELECT * FROM user WHERE username = #{username} LIMIT 1")
    User getUserByName(String username);
}
