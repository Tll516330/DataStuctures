package com.tll.file;

import java.io.*;

/**
 * @author tll
 * @create 2020/6/1 9:03
 * 缓存流
 */
public class BufferDemo {
    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        try(
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\chormDown\\YNote.exe"));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("D:\\chormDown\\YNote_copy.exe"));
                ) {
            //读取数据 使用数组会更快一点
            int b ;
            byte[] bytes = new byte[80 * 1024];
            while ((b=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流所用的时间"+(end-startTime)+"毫秒");
    }
}
