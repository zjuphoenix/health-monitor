package com.edu.zju.lab.health.monitor;

import com.edu.zju.lab.health.monitor.dao.*;
import com.edu.zju.lab.health.monitor.entity.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by MCH on 2015/11/13.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HealthMonitorApp.class)
public class DBTest {
    @Autowired
    BloodKetoneMapper bloodKetoneMapper;
    @Autowired
    BloodOxygenMapper bloodOxygenMapper;
    @Autowired
    BloodPressureMapper bloodPressureMapper;
    @Autowired
    BloodSugarMapper bloodSugarMapper;
    @Autowired
    EcgMapper ecgMapper;

    @Test
    public void test() {
        long time = new Date().getTime();
        Random random = new Random();
        int systolic_pressure, diastolic_pressure;
//
        for(int i = 0; i < 10; i++){
//            bloodKetoneMapper.insert(new BloodKetone(2, time, 0.1722+random.nextInt(861)*0.0001, false));
//
//            bloodOxygenMapper.insert(new BloodOxygen(2, time, 120 + random.nextInt(75), 93+random.nextInt(6), 2+random.nextInt(4), false));
//            bloodPressureMapper.insert(new BloodPressure(2, time, systolic_pressure = 100+random.nextInt(10), diastolic_pressure = 70+random.nextInt(10), (systolic_pressure+diastolic_pressure)/2, 18 + random.nextInt(6), false));
//            bloodSugarMapper.insert(new BloodSugar(2, time, (69+random.nextInt(12))*0.1, false));
            ecgMapper.insert(new Ecg(2, time, 19 + random.nextInt(4), 85 + random.nextInt(10), false));
//
            time+=10000;
        }


//        List<BloodKetone> bloodKetoneList = bloodKetoneMapper.getBloodKetone(0,123);
//        for(BloodKetone bk : bloodKetoneList){
//            System.out.println(bk.getBloodKetone());
//        }
    }
}
