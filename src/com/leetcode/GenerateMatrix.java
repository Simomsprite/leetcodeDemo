/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GenerateMatrix
 * Author:   王小手
 * Date:     2019/12/2 15:53
 * Description: 螺旋矩阵 II
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈螺旋矩阵 II〉
 *输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author
 * @create 2019/12/2
 * @since 1.0.0
 */
public class GenerateMatrix {
    public static void main(String[] args) {

    }

    private static int[][] minNum(int target){
        int left=0,right=target-1,top=0,down=target-1;
        int[][] format=new int[target][target];
        int tar=target^2;
        int n=1;
        while (n<=tar){
            for (int i=left;i<=right;i++) format[top][i]=n++;
            top++;
            for (int i=top;i<=down;i++) format[i][right]=n++;
            right--;
            for (int i=right;i>=left;i--) format[down][i]=n++;
            down--;
            for (int i=down;i>=top;i--) format[i][left]=n++;
            left++;
        }
        return format;
    }


}