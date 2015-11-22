package com.edu.zju.lab.health.monitor.controller;

import com.edu.zju.lab.health.monitor.dao.EcgFileDao;
import com.edu.zju.lab.health.monitor.dao.EcgMapper;
import com.edu.zju.lab.health.monitor.entity.Ecg;
import com.edu.zju.lab.health.monitor.entity.EcgFileEntity;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/10/14.
 */
@Controller
@RequestMapping("/ecg")
public class EcgController {
    @Autowired
    EcgMapper ecgMapper;
    @Autowired
    EcgFileDao ecgFileDao;
    private Logger logger = LoggerFactory.getLogger(EcgController.class);

    private short[][] readFileByBytes(String fileName) {
        //三导联。每导联10秒，采样率为500/s
        short[][] res=new short[3][5000];
        InputStream in = null;

        try {
            //每次读三导联的一秒
            byte[] tempbytes = new byte[3000];
            in = EcgController.class.getResourceAsStream(fileName);
            int num=0;
            int numOfBytes;
            while ((numOfBytes=in.read(tempbytes))!= -1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = i*numOfBytes/3; j < (i+1)*numOfBytes/3; j+=2) {
                        res[i][num+(j-i*numOfBytes/3)/2]=(short)(((tempbytes[j]&0xff)<<8)|(tempbytes[j+1]&0xff));
                    }
                }
                num+=numOfBytes/3/2;
            }

        }catch (FileNotFoundException e){
            System.out.println("指定文件路径不存在");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("输入文件过长，超出预定格式！");
        }
        catch (IOException e) {
            System.out.println("文件流异常");
        }
        //关闭输入流
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("文件流关闭失败");
                    e.printStackTrace();
                }
            }

        }
        return res;
    }

    @RequestMapping("/records")
    public ModelAndView records() {
        Map<String, Ecg> res = new TreeMap<>(new Comparator() {
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
//            Ecg ecg = new Ecg();
//            ecg.setBreath_rate(random.nextInt(5)+15);
//            ecg.setHeart_rate(random.nextInt(10)+70);
//            res.put(s.format(date),ecg);
//            calendar.roll(Calendar.SECOND, 10);
//        }

        List<Ecg> ecgList = ecgMapper.getEcg();
        for(Ecg ecg : ecgList){
            Date date = new Date(ecg.getTimeStamp());
            res.put(s.format(date),ecg);
        }
        return new ModelAndView("ecg-records",new ImmutableMap.Builder<String, Object>()
                .put("ecg",res)
                .build());
    }

    @RequestMapping("/detail")
     public ModelAndView detail() {
        return new ModelAndView("ecg-detail");
    }

    @RequestMapping(value="/query",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Map<Long, Integer>> query(@RequestParam("start") String start,@RequestParam("end") String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        long starttime = 0;
        long endtime = 0;
        try {
            starttime = sdf.parse(start).getTime();
            endtime = sdf.parse(end).getTime();
        } catch (ParseException e) {
            logger.error("date parse exception", e);
        }
        Map<String, Map<Long, Integer>> res = new HashMap<>();
        /*Map<String, Double> breath_rate = new HashMap<>();
        breath_rate.put("2015-10-16 14:00",128.0);
        breath_rate.put("2015-10-16 14:01",158.0);
        breath_rate.put("2015-10-16 14:02",210.0);
        Map<String, Double> heart_rate = new HashMap<>();
        heart_rate.put("2015-10-16 14:00",128.0);
        heart_rate.put("2015-10-16 14:01",158.0);
        heart_rate.put("2015-10-16 14:02",210.0);*/
        Map<Long, Integer> first_lead = new TreeMap<>();
        Map<Long, Integer> second_lead = new TreeMap<>();
        Map<Long, Integer> third_lead = new TreeMap<>();
//        Calendar calendar = Calendar.getInstance();
        Long base;
//        Random random = new Random();
//        short[][] ecg = readFileByBytes("/ecg-raw1.dat");
        List<EcgFileEntity> ecgFileEntityList = ecgFileDao.queryEcg("123", start+":00", end+":00");
//        for (int i = 0; i < 5000; i++) {
//            base+=2;
//            first_lead.put(base, (int)ecg[0][i]);
//            second_lead.put(base,(int)ecg[1][i]);
//            third_lead.put(base, (int)ecg[2][i]);
//        }

        for(EcgFileEntity efe:ecgFileEntityList){
            base = efe.getTimeStamp();
            for(int i = 0; i < 500; i++){
                first_lead.put(base, (int)efe.getEcgs()[0][i]);
                second_lead.put(base,(int)efe.getEcgs()[1][i]);
                third_lead.put(base, (int)efe.getEcgs()[2][i]);
                base += 2;
            }
        }

        /*res.put("breath_rate",breath_rate);
        res.put("heart_rate",heart_rate);*/
        res.put("first_lead",first_lead);
        res.put("second_lead",second_lead);
        res.put("third_lead",third_lead);
        return res;
       // return "1223";
    }
}
