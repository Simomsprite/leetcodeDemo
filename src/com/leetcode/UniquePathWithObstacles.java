/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UniquePathWithObstacles
 * Author:   王小手
 * Date:     2019/12/3 11:08
 * Description: 不同路径2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈不同路径2〉
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * @author
 * @create 2019/12/3
 * @since 1.0.0
 */
public class UniquePathWithObstacles {
    public static void main(String[] args) {

    }

    private static int uniquePathWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0 && j==0){
                    dp[0][0]=obstacleGrid[0][0]==1 ? 0:1;
                }else if (i==0){
                    if (dp[i][j-1]!=0 && obstacleGrid[i][j]!=1){
                        dp[i][j]=1;
                    }
                }else if (j==0){
                    if (dp[i-1][j]!=0 && obstacleGrid[i][j]!=1){
                        dp[i][j]=1;
                    }
                }else if (obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}