package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.entity.Ecg;
import com.edu.zju.lab.health.monitor.entity.Record;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/10/23.
 */
@Controller
@RequestMapping("/records")
public class MonitorRecordController {
    @RequestMapping()
    public ModelAndView index() {
        Map<String, Record> res = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o2.toString().compareTo(o1.toString());
            }
        });
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 5; i++) {
            Date date = calendar.getTime();
            Record record = new Record();
            record.setStatus("异常");
            res.put(s.format(date),record);
            calendar.roll(Calendar.DAY_OF_MONTH, 1);
        }
        return new ModelAndView("records",new ImmutableMap.Builder<String, Object>()
                .put("records",res)
                .build());
    }

    @RequestMapping("/analysis")
    public ModelAndView analysis() {
        return new ModelAndView("analysis");
    }
}
