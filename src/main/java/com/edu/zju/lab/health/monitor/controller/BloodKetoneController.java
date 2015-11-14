package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.BloodKetoneMapper;
import com.edu.zju.lab.health.monitor.entity.BloodKetone;
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
 * Created by Administrator on 2015/10/16.
 */
@Controller
@RequestMapping("/bloodketone")
public class BloodKetoneController {
    @Autowired
    BloodKetoneMapper bloodKetoneMapper;
    private Logger logger = LoggerFactory.getLogger(BloodKetoneController.class);

    @RequestMapping("/records")
    public ModelAndView records() {
        Map<String, Double> res = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString())*(-1);
            }
        });
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BloodKetone> bloodKetoneList = bloodKetoneMapper.getBloodKetone();
        for(BloodKetone bk : bloodKetoneList){
            Date date = new Date(bk.getTimeStamp());
            res.put(s.format(date), (double) bk.getBloodKetone());
        }
//        for (int i = 0; i < 10; i++) {
//            Date date = calendar.getTime();
//            calendar.roll(Calendar.SECOND,10);
//            res.put(s.format(date), (random.nextInt(100)+6000)*0.0001);
//        }
        return new ModelAndView("bloodketone-records",new ImmutableMap.Builder<String, Object>()
                .put("bloodketone",res)
                .build());
    }

    @RequestMapping("/detail")
    public ModelAndView detail() {
        return new ModelAndView("bloodketone-detail");
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Double> query(@RequestParam("start") String start,@RequestParam("end") String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        long starttime = 0;
        long endtime = 0;
        try {
            starttime = sdf.parse(start).getTime();
            endtime = sdf.parse(end).getTime();
        } catch (ParseException e) {
            logger.error("date parse exception", e);
        }
        Map<String, Double> res = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            Date date = calendar.getTime();
            calendar.add(Calendar.SECOND,10);
            res.put(s.format(date), (random.nextInt(100)+6000)*0.0001);
        }
        return res;
    }
}
