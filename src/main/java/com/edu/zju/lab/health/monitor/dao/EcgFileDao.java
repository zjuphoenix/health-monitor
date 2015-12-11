package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.EcgFileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaitao on 2015/11/14.
 * 文件格式:文件名为{userID}_ecg_{yyyy-MM-dd}
 * 文件内容:起始时间yyyy/MM/dd HH:mm:ss+3513*n
 */
@Repository
public class EcgFileDao {
    private static Logger logger = LoggerFactory.getLogger(EcgFileDao.class);

    //文件路径使用classpath会有问题，暂时用全路径
    private static final String rootPath = "/root/HealthMonitor/data/";
//    private static final String rootPath = "E:\\ECGFile\\";
    public List<EcgFileEntity> queryEcg(String userID, String date, long start, long end){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

        List<EcgFileEntity> ecgFileEntityList = new ArrayList<EcgFileEntity>();

        byte[] timestampBytes = new byte[19];

        byte[] head = new byte[3];
        byte[] breathingRateBytes = new byte[2];
        byte[] stBytes = new byte[6];
        byte[] heartrateBytes = new byte[2];
        byte[][] ecgsBytes = new byte[3][1000];
        byte[] flagBytes = new byte[500];

        int breathingRate;
        int[] sts = new int[3];
        int heartrate;
        short[][] ecgs = new short[3][500];

        try {
            String filename = rootPath + userID + "_ecg_"+date;
            File file=new File(filename);
            System.out.println(file.exists() + " " + file.length());
            System.out.println(file.getAbsolutePath());
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            raf.read(timestampBytes);
            long timestamp = sdf1.parse(new String(timestampBytes)).getTime();
            if(start > timestamp){
                long startPointer = (start - timestamp)*3513/1000+19;
                raf.seek(startPointer);
                timestamp = start;
            }
            long endPointer = (end - timestamp)*3513/1000+raf.getFilePointer();
//            String filename = rootPath+surgery_no+"_ecg_"+sdf2.format(sdf1.parse(start));
//            String filename = rootPath + userID + "_ecg_2015-11-30";
//            String filename = rootPath + "ecg-raw1.dat";
//            File file=new File(filename);
//            System.out.println(file.exists() + " " + file.length());
//            System.out.println(file.getAbsolutePath());
//            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
//            InputStream fis=new FileInputStream(file);
            if(raf.length() < endPointer) endPointer = raf.length();



            while(raf.getFilePointer() < endPointer){
                raf.read(head);
                raf.read(breathingRateBytes);
                raf.read(stBytes);
                raf.read(heartrateBytes);
                raf.read(ecgsBytes[0]);
                raf.read(ecgsBytes[1]);
                raf.read(ecgsBytes[2]);
                raf.read(flagBytes);

                breathingRate = (((breathingRateBytes[0]&0xff)<<8)|(breathingRateBytes[1]&0xff));
                for(int i = 0; i < 3; i++){
                    sts[i] = (((stBytes[2*i]&0xff)<<8)|(stBytes[2*i+1]&0xff));
                }
                heartrate = (((heartrateBytes[0]&0xff)<<8)|(heartrateBytes[1]&0xff));
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 500; j++) {
                        ecgs[i][j]=(short)(((ecgsBytes[i][2*j]&0xff)<<8)|(ecgsBytes[i][2*j+1]&0xff));
                    }
                }
                ecgFileEntityList.add(new EcgFileEntity(timestamp,breathingRate,sts,heartrate,ecgs,flagBytes));
                timestamp += 1000;
            }

//            long pointer = raf.getFilePointer();
//            int one = 3513+10;
//            raf.seek(((pointer-one)/one)*one+10);
//            byte[] data = new byte[3513];
//            raf.read(data);

        } catch (IOException e) {
            logger.error("read ecg file data occur io exception");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ecgFileEntityList;
    }
}
