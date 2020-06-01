package com.tll.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author tll
 * @create 2020/5/31 14:09
 * 对数据的读取与写入
 */
public class FileIo {
    public static void main(String[] args) throws IOException {
        //1.先创建流对象
        //指定数据源  绝对路径
        FileInputStream in = new FileInputStream("D:\\截图\\testSinpate.png");
        //指定目的地  相对路径
        FileOutputStream out = new FileOutputStream("testSinpate_copy.png");

        //2.读取数据
        //2.1创建数组
        byte[] bytes = new byte[1024];
        //2.2定义长度
        int len ;
        //2.3循环读取
        while ((len = in.read(bytes))!=-1){
            //写出数据
            out.write(bytes,0,len);
        }
        //关闭资源  先开后关，后开先关
        out.close();
        in.close();
    }
}
