/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FindeArray
 * Author:   王小手
 * Date:     2019/11/27 14:17
 * Description: 二维数组查找
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二维数组查找〉
 *
 * @author
 * @create 2019/11/27
 * @since 1.0.0
 */
public class FindeArray {
    public static void main(String[] args) {


    }

    private boolean findArray(int[][] arr,int target){
        int row=arr.length;
        int col=arr[0].length;
        if (row==0){
            return false;
        }
        if (col==0){
            return false;
        }

        int rows=row-1;
        int cols=0;
        while (row>=0 && cols<col){
            if (arr[rows][cols]<target){
                cols++;
            }else if (arr[rows][cols]>target){
                rows--;
            }else{
                return true;
            }
        }
        return false;
    }

}