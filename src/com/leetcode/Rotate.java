/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Rotate
 * Author:   王小手
 * Date:     2019/11/29 14:52
 * Description: 旋转图像
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈旋转图像〉
 *给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * @author
 * @create 2019/11/29
 * @since 1.0.0
 */
public class Rotate {
    public static void main(String[] args) {
int n=3;
System.out.println(n/2);

    }

    private static void  rotate(int[][] matrix){
        int n=matrix.length-1;
        for (int i=0;i<=n/2;i++){
            for (int j=i;j<n-i;j++){
                int temp=matrix[i][j];
                matrix[i][j] = matrix[n - j][i];

                matrix[n - j][i] = matrix[n - i][n - j];

                matrix[n - i][n - j] = matrix[j][n - i];

                matrix[j][n - i] = temp;
            }

        }
    }

}

















































