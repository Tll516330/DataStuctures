package com.tll.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author tll
 * @create 2020/6/1 9:33
 * 字符缓冲流
 */
public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建流对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\电子书\\a.txt"));
        //定义字符串
        String line = null;
        //循环读取，读到最后一行为null
        while ((line = bufferedReader.readLine())!=null){
            System.out.println("一行中的数据"+line);
            System.out.println("===========");
        }
        //释放资源
        bufferedReader.close();
    }
}
