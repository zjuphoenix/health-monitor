package com.edu.zju.lab.health.monitor;

import com.edu.zju.lab.health.monitor.dao.BloodKetoneMapper;
import com.edu.zju.lab.health.monitor.entity.BloodKetone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by MCH on 2015/11/13.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthMonitorApp.class)
public class DBTest {
    @Autowired
    BloodKetoneMapper bloodKetoneMapper;
    @Test
    public void test() {
    bloodKetoneMapper.insert(new BloodKetone(123, 765685654, (float) 2.3, false));
    }
}
