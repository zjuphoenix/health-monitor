package com.edu.zju.lab.health.monitor;

import com.edu.zju.lab.health.monitor.dao.BloodKetoneMapper;
import com.edu.zju.lab.health.monitor.entity.BloodKetone;

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
    @Test
    public void test() {
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
//        for(int i = 0; i < 10; i++){
//            bloodKetoneMapper.insert(new BloodKetone(123, calendar.getTime().getTime(), (float) ((random.nextInt(100)+6000)*0.0001), false));
//            calendar.roll(Calendar.SECOND,10);
//        }
        List<BloodKetone> bloodKetoneList = bloodKetoneMapper.getBloodKetone();
        for(BloodKetone bk : bloodKetoneList){
            System.out.println(bk.getTimeStamp());
        }
    }
}
