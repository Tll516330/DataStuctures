package com.tll.sparsearry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tll
 * @create 2020/6/1 10:38
 */
public class SparseArryTest {
    public static void main(String[] args) {
        //1.创建一个11*11二维数组
        int[][] arryOne = new int[11][11];
        //2.向二维数组中添加数据
        //0-没有棋子    1-白棋子   2-黑棋子
        arryOne[1][2] = 1;
        arryOne[2][1] = 2;
        arryOne[5][6] = 1;
        arryOne[6][5] = 2;

        //打印原始数据
        for (int[] ints : arryOne) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //将二维数组转换成稀疏数组
        int sum =0;
        for (int[] ints : arryOne) {
            for (int anInt : ints) {
                if (anInt!=0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] arryTwo = new int[sum + 1][3];
        arryTwo[0][0] = arryOne.length;
        arryTwo[0][1] = arryOne[0].length;
        arryTwo[0][2] = sum;

        int row = 0 ;
        for (int i = 0; i < arryOne.length ; i++) {
            for (int j = 0; j <arryOne[0].length ; j++) {
                if (arryOne[i][j]!=0){
                    row++;
                    arryTwo[row][0] = i;
                    arryTwo[row][1] = j;
                    arryTwo[row][2] = arryOne[i][j];
                }
            }

        }

        //打印稀疏数组
        System.out.println("稀疏数组");
        for (int[] ints : arryTwo) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //将稀疏数组存入磁盘中
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\电子书\\arry.txt"));
            for (int[] ints : arryTwo) {
                for (int anInt : ints) {
                    bufferedWriter.write(anInt+"\t");
                }
                bufferedWriter.write("\r\n");
            }

            //释放资源
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list = new ArrayList<>();
        //从磁盘中取出数据
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\电子书\\arry.txt"));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                String[] split = line.split("\t");
                for (int i = 0; i <split.length ; i++) {
                    list.add(Integer.valueOf(split[i]));
                }
            }
            //创建一个新的二维数组
            int[][] arryThree = new int[list.get(0)][list.get(1)];
            // 将数据存入
            for (int i = 3; i <list.size() ; i=i+3) {
                arryThree[list.get(i)][list.get(i+1)] = list.get(i+2);
            }
            System.out.println("从磁盘中转换过来的新数组");
            for (int[] ints : arryThree) {
                for (int anInt : ints) {
                    System.out.printf("%d\t",anInt);
                }
                System.out.println();
            }
            //释放资源
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
