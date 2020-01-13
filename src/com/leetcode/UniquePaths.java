/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UniquePaths
 * Author:   王小手
 * Date:     2019/12/2 18:07
 * Description: 不同路径
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈不同路径〉
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * @author
 * @create 2019/12/2
 * @since 1.0.0
 */
public class UniquePaths {
    public static void main(String[] args) {

    }

    private static int uniquePaths(int m,int n){
        int[] arr=new int[n];
        Arrays.fill(arr,1);
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                arr[j]=arr[j]+arr[j-1];
            }
        }
        return arr[n-1];
    }

    private static int uniquePaths2(int m,int n){
        int[][] arr=new int[m][n];
        for (int i=0;i<m;i++) arr[i][0]=1;
        for (int i=0;i<n;i++) arr[0][i]=1;
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }

}