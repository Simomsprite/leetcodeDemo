/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SetZeroes
 * Author:   王小手
 * Date:     2019/12/3 15:08
 * Description: 矩阵置零
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈矩阵置零〉
 *给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author
 * @create 2019/12/3
 * @since 1.0.0
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] arr={{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    private static  void setZeroes(int[][] matrix){
        int m= matrix.length;
        int n=matrix[0].length;
        if (matrix.length==0 && matrix[0].length==0){
            return ;
        }
        boolean[] row=new boolean[m];
        boolean[] col=new boolean[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    row[i]=true;
                    col[j]= true;
                }
            }
        }
        for (int i=0;i<m;i++){
            if (row[i]){
                for (int j=0;j<n;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int j=0;j<n;j++){
            if (col[j]){
                for (int i=0;i<m;i++){
                    matrix[i][j]=0;
                }
            }
        }
    }
}