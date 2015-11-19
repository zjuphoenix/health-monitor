package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.BloodPressureMapper;
import com.edu.zju.lab.health.monitor.entity.BloodPressure;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/10/15.
 */
@Controller
@RequestMapping("/bloodpressure")
public class BloodPressureController {
    @Autowired
    BloodPressureMapper bloodPressureMapper;

    private Logger logger = LoggerFactory.getLogger(BloodPressureController.class);

    @RequestMapping("/records")
    public ModelAndView records() {
        Map<String, BloodPressure> res = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString())*(-1);
            }
        });
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (int i = 0; i < 10; i++) {
//            Date date = calendar.getTime();
//            BloodPressure bloodPressure = new BloodPressure();
//            bloodPressure.setSystolic_pressure(random.nextInt(20)+100);
//            bloodPressure.setDiastolic_pressure(random.nextInt(20)+60);
//            bloodPressure.setMean_pressure(random.nextInt(20)+80);
//            bloodPressure.setPulse_rate(random.nextInt(10)+80);
//            res.put(s.format(date),bloodPressure);
//            calendar.roll(Calendar.SECOND, 10);
//        }

        List<BloodPressure> bloodPressureList = bloodPressureMapper.getBloodPressure();
        for(BloodPressure bp : bloodPressureList){
            Date date = new Date(bp.getTimeStamp());
            res.put(s.format(date), bp);
        }

        return new ModelAndView("bloodpressure-records",new ImmutableMap.Builder<String, Object>()
                .put("bloodpressure",res)
                .build());
    }

    @RequestMapping("/detail")
    public ModelAndView detail() {
        return new ModelAndView("bloodpressure-detail");
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Map<String, Double>> query(@RequestParam("start") String start,@RequestParam("end") String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        long starttime = 0;
        long endtime = 0;
        try {
            starttime = sdf.parse(start).getTime();
            endtime = sdf.parse(end).getTime();
        } catch (ParseException e) {
            logger.error("date parse exception", e);
        }
        Map<String, Map<String, Double>> res = new HashMap<>();
        Map<String, Double> systolic_pressure = new TreeMap<>();
        Map<String, Double> diastolic_pressure = new TreeMap<>();
        Map<String, Double> mean_pressure = new TreeMap<>();
        Map<String, Double> pulse_rate = new TreeMap<>();
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<BloodPressure> bloodPressureList = bloodPressureMapper.getBloodPressureByTime(starttime, endtime);
        for(BloodPressure bp : bloodPressureList){
            Date date = new Date(bp.getTimeStamp());
            systolic_pressure.put(s.format(date), bp.getSystolic_pressure()*1.0);
            diastolic_pressure.put(s.format(date), bp.getDiastolic_pressure()*1.0);
            mean_pressure.put(s.format(date), bp.getMean_pressure()*1.0);
            pulse_rate.put(s.format(date), bp.getPulse_rate()*1.0);
        }

//        for (int i = 0; i < 10; i++) {
//            Date date = calendar.getTime();
//            systolic_pressure.put(s.format(date),(double)(random.nextInt(20)+100));
//            diastolic_pressure.put(s.format(date),(double)(random.nextInt(20)+60));
//            mean_pressure.put(s.format(date),(double)(random.nextInt(20)+80));
//            pulse_rate.put(s.format(date),(double)(random.nextInt(10)+80));
//            calendar.add(Calendar.SECOND,10);
//        }
        res.put("systolic_pressure",systolic_pressure);
        res.put("diastolic_pressure",diastolic_pressure);
        res.put("mean_pressure",mean_pressure);
        res.put("pulse_rate",pulse_rate);
        return res;
    }
}
