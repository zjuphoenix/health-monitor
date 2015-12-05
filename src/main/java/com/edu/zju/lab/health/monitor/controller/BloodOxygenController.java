package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.BloodOxygenMapper;
import com.edu.zju.lab.health.monitor.entity.BloodOxygen;
import com.edu.zju.lab.health.monitor.entity.User;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/10/15.
 */
@Controller
@RequestMapping("/bloodoxygen")
public class BloodOxygenController {
    @Autowired
    BloodOxygenMapper bloodOxygenMapper;
    private Logger logger = LoggerFactory.getLogger(BloodOxygenController.class);

    @RequestMapping("/records")
    public ModelAndView records(HttpServletRequest request, @RequestParam(value = "page",required = false,defaultValue = "0") int page) {
        Map<String, BloodOxygen> res = new TreeMap<>(new Comparator() {
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
//            BloodOxygen bloodOxygen = new BloodOxygen();
//            bloodOxygen.setPulse_rate((random.nextInt(10)+80));
//            bloodOxygen.setSaturation((random.nextInt(3) + 95));
//            bloodOxygen.setPulse_intensity((random.nextInt(20) + 60));
//            res.put(s.format(date),bloodOxygen);
//            calendar.roll(Calendar.SECOND, 10);
//        }

        User user = (User)request.getSession().getAttribute("user");
        int id = user.getId();
        long pagecount = bloodOxygenMapper.getBloodOxygenCount();
        List<BloodOxygen> bloodOxygenList = bloodOxygenMapper.getBloodOxygen(page*5, id);
        for(BloodOxygen bo : bloodOxygenList){
            Date date = new Date(bo.getTimeStamp());
            res.put(s.format(date), bo);
        }

        return new ModelAndView("bloodoxygen-records",new ImmutableMap.Builder<String, Object>()
                .put("bloodoxygen",res)
                .put("page",page)
                .put("pagecount", pagecount % 5 == 0 ? pagecount/5:pagecount/5+1)
                .build());
    }

    @RequestMapping("/detail")
    public ModelAndView detail() {
        return new ModelAndView("bloodoxygen-detail");
    }

    @RequestMapping("/query")
    @ResponseBody
    public Map<String, Map<String, Double>> query(HttpServletRequest request, @RequestParam("start") String start,@RequestParam("end") String end) {
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
        Map<String, Double> saturation = new HashMap<>();
        Map<String, Double> pulse_intensity = new HashMap<>();
        Map<String, Double> waveform = new TreeMap<>();
        Map<String, Double> pulse_rate = new HashMap<>();
//        Calendar calendar = Calendar.getInstance();
//        Random random = new Random();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        User user = (User)request.getSession().getAttribute("user");
        int id = user.getId();
        List<BloodOxygen> bloodOxygenList = bloodOxygenMapper.getBloodOxygenByTime(starttime, endtime, id);
        for(BloodOxygen bo : bloodOxygenList){
            Date date = new Date(bo.getTimeStamp());
            waveform.put(s.format(date), bo.getSaturation()*1.0);
        }

//        for (int i = 0; i < 10; i++) {
//            Date date = calendar.getTime();
//            /*pulse_rate.put(date.toString(),(double)(random.nextInt(10)+80));
//            saturation.put(date.toString(),(double)(random.nextInt(20)+100));
//            pulse_intensity.put(date.toString(),(double)(random.nextInt(20)+60));*/
//            waveform.put(s.format(date),(double)(random.nextInt(20)+80));
//            calendar.add(Calendar.SECOND,10);
//        }
        /*res.put("pulse_rate",pulse_rate);
        res.put("saturation",saturation);
        res.put("pulse_intensity",pulse_intensity);*/
        res.put("waveform",waveform);
        return res;
    }
}
