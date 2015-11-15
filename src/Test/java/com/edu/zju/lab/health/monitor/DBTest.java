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
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
//        int systolic_pressure, diastolic_pressure;
//
//        for(int i = 0; i < 10; i++){
////            bloodKetoneMapper.insert(new BloodKetone(123, calendar.getTime().getTime(), (float) (0.1722+random.nextInt(861)*0.0001), false));
//
//            bloodOxygenMapper.insert(new BloodOxygen(123,calendar.getTime().getTime(), 60 + random.nextInt(195), 92+random.nextInt(8), random.nextInt(8), false));
//            bloodPressureMapper.insert(new BloodPressure(123, calendar.getTime().getTime(), systolic_pressure = 90+random.nextInt(30), diastolic_pressure = 60+random.nextInt(30), (systolic_pressure+diastolic_pressure)/2, 16 + random.nextInt(10), false));
//            bloodSugarMapper.insert(new BloodSugar(123, calendar.getTime().getTime(), (39+random.nextInt(72))*0.1, false));
//            ecgMapper.insert(new Ecg(123, calendar.getTime().getTime(), 16 + random.nextInt(10), 60 + random.nextInt(60), false));
//
//            calendar.roll(Calendar.SECOND, 10);
//        }


        List<BloodKetone> bloodKetoneList = bloodKetoneMapper.getBloodKetone();
        for(BloodKetone bk : bloodKetoneList){
            System.out.println(bk.getBloodKetone());
        }
    }
}
