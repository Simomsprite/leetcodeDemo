/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SearchMatrix
 * Author:   王小手
 * Date:     2019/12/3 17:58
 * Description: 搜索二位数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索二位数组〉
 *输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * @author
 * @create 2019/12/3
 * @since 1.0.0
 */
public class SearchMatrix {
    public static void main(String[] args) {

    }

    private static boolean searchMatrix(int[][] matrix,int target){
        if (matrix.length==0 && matrix[0].length==0){
            return false;
        }
        int m= matrix.length;
        int n=matrix[0].length;
        int left=0,right=n*m-1;
        while (left<right){
            int mid=(left+right)/2;
            int midNum=matrix[mid/n][mid%n];
            if (midNum==target){
                return true;
            }else{
                if (midNum>target){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return false;
    }
}