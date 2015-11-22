package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.BloodSugarMapper;
import com.edu.zju.lab.health.monitor.entity.BloodSugar;
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
@RequestMapping("/bloodsugar")
public class BloodSugarController {
    @Autowired
    BloodSugarMapper bloodSugarMapper;

    private Logger logger = LoggerFactory.getLogger(BloodSugarController.class);

    @RequestMapping("/records")
    public ModelAndView records(@RequestParam(value = "page",required = false,defaultValue = "0") int page) {
        Map<String, Double> res = new TreeMap<>(new Comparator() {
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
//            calendar.roll(Calendar.SECOND,10);
//            res.put(s.format(date), (random.nextInt(22)+39)*0.1);
//        }
        long pagecount = bloodSugarMapper.getBloodSugarCount();
        List<BloodSugar> bloodSugarList = bloodSugarMapper.getBloodSugar(page*5);
        for(BloodSugar bs : bloodSugarList){
            Date date = new Date(bs.getTimeStamp());
            res.put(s.format(date), bs.getBloodSugar());
        }
        return new ModelAndView("bloodsugar-records",new ImmutableMap.Builder<String, Object>()
                .put("bloodsugar",res)
                .put("page",page)
                .put("pagecount", pagecount%5==0?pagecount/5:pagecount/5+1)
                .build());
    }

    @RequestMapping("/detail")
    public ModelAndView detail() {
        return new ModelAndView("bloodsugar-detail");
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
        Map<String, Double> res = new TreeMap<>();
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<BloodSugar> bloodSugarList = bloodSugarMapper.getBloodSugarByTime(starttime, endtime);
        for(BloodSugar bs : bloodSugarList){
            Date date = new Date(bs.getTimeStamp());
            res.put(s.format(date), bs.getBloodSugar());
        }

//        for (int i = 0; i < 10; i++) {
//            Date date = calendar.getTime();
//            calendar.add(Calendar.SECOND,10);
//            res.put(s.format(date), (random.nextInt(22)+39)*0.1);
//        }
        return res;
    }
}
