package com.tll.file;

import java.io.*;
import java.util.HashMap;

/**
 * @author tll
 * @create 2020/6/1 9:47
 * 将文本信息  按顺序打印出来
 */
public class BufferedTest {
    public static void main(String[] args) {
        //创建一个map集合，保存文本数据，健为序号，值为文字
        HashMap<String, String> listMap = new HashMap<>();

        //创建流对象
        try {
            //输入流
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\电子书\\in.txt"));
            //输出流
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\电子书\\out.txt"));
            //读取数据
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                //解析文本
                String[] split = line.split("\\.");
                //保存到集合
                listMap.put(split[0],split[1]);
            }
            //遍历map集合
            for (int i = 1; i <listMap.size() ; i++) {
                String key = String.valueOf(i);
                //获取map中的文本
                String value = listMap.get(key);
                //写出拼接文本
                bufferedWriter.write(key+"."+value);
                //换行
                bufferedWriter.newLine();
            }

            //释放资源
            bufferedWriter.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
