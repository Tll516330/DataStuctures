package com.tll.sparsearry;

/**
 * @author tll
 * @create 2020/5/29 14:53
 * 创建一个稀疏数组
 */
public class SparseArry {
    public static void main(String[] args) {

        //初始二维数组
        int[][] chessArry1 = new int[10][11];
        //插入数据
        //0-代表没棋子  1-代表黑色棋子  2-代表蓝色棋子
        chessArry1[1][2] = 1;
        chessArry1[2][3] = 2;
        chessArry1[5][6] = 1;
        chessArry1[6][5] = 2;

        System.out.println("输出原始二维数组");
        for (int[] ints : chessArry1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        System.out.println("将原始数组转换成稀疏数组");
        //遍历二维数组  得到有棋子的个数
        int sum = 0;
        for (int i = 0; i < chessArry1.length; i++) {
            for (int j = 0; j < chessArry1[0].length; j++) {
                if (chessArry1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("数组中有" + sum + "值");
        //先创建一个sparseArry
        int[][] sparseArry = new int[sum + 1][3];
        //开始想稀疏数组中存入数据

        sparseArry[0][0] = chessArry1.length;
        sparseArry[0][1] = chessArry1[0].length;
        sparseArry[0][2] = sum;

        //遍历chessarry数组 将有棋子的位置存入到稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArry1.length; i++) {
            for (int j = 0; j < chessArry1[0].length; j++) {
                if (chessArry1[i][j] != 0) {
                    count++;
                    sparseArry[count][0] = i;
                    sparseArry[count][1] = j;
                    sparseArry[count][2] = chessArry1[i][j];
                }
            }
        }

        System.out.println("打印稀疏数组");
        for (int[] ints : sparseArry) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        System.out.println("将稀疏数组转化成chessarry");
        //新建一个数组
        int[][] ints = new int[sparseArry[0][0]][sparseArry[0][1]];
        for (int i = 1; i < sparseArry.length; i++) {
            ints[sparseArry[i][0]][sparseArry[i][1]] = sparseArry[i][2];
        }

        System.out.println("打印解压后的数组");
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }
    }
}
