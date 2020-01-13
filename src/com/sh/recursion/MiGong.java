/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MiGong
 * Author:   王小手
 * Date:     2019/7/2 21:46
 * Description: 迷宫
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.recursion;

/**
 * 〈一句话功能简述〉<br> 
 * 〈迷宫〉
 *
 * @author wxs
 * @create 2019/7/2
 * @since 1.0.0
 */
public class MiGong {
    public static void main(String[] args) {

        int[][] map = new int[8][7];

        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }

        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }

        map[3][1]=1;
        map[3][2]=1;
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}