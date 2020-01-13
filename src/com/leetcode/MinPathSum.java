/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MinPathSum
 * Author:   王小手
 * Date:     2019/12/3 11:53
 * Description: 最小路径综合
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最小路径综合〉
 *输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * @author
 * @create 2019/12/3
 * @since 1.0.0
 */
public class MinPathSum {
    public static void main(String[] args) {

    }

    private static int minPathSum(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0 && j==0){
                    continue;
                }
                if (i==0 && j>0){
                    grid[i][j]+=grid[0][j-1];
                    continue;
                }
                if (j==0 && i>0){
                    grid[i][j]+=grid[i-1][0];
                    continue;
                }
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }

}