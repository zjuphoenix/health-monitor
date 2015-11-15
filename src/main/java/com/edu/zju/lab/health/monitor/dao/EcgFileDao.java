package com.edu.zju.lab.health.monitor.dao;

import com.edu.zju.lab.health.monitor.entity.EcgFileEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by wuhaitao on 2015/11/14.
 * 文件格式:文件名为{surgery_no}_ecg_{yyyy-MM-dd}
 * 文件内容:起始时间yyyy-MM-dd HH:mm:ss+3513*n
 */
@Repository
public class EcgFileDao {
    private static Logger logger = LoggerFactory.getLogger(EcgFileDao.class);
    private static final String rootPath = "";
    /*List<EcgFileEntity> queryEcg(String surgery_no, String start, String end){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long number = sdf1.parse(end).getTime() - sdf1.parse(start).getTime();
            for
            String filename = rootPath+surgery_no+"_ecg_"+sdf2.format(sdf1.parse(start));
            RandomAccessFile raf = new RandomAccessFile(filename, "rw");
            byte[] timestamp = new byte[10];
            if(raf.read(timestamp)==10){

            }
            long pointer = raf.getFilePointer();
            int one = 3513+10;
            raf.seek(((pointer-one)/one)*one+10);
            byte[] data = new byte[3513];
            raf.read(data);
            return data;
        } catch (IOException e) {
            logger.error("read ecg file data occur io exception");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/
}
