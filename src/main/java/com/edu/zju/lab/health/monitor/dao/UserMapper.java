package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2015/10/14.
 */
public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username} LIMIT 1")
    User getUserByName(String username);
}