/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MaxArea
 * Author:   王小手
 * Date:     2019/11/26 15:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈盛最多水〉
 *
 * @author
 * @create 2019/11/26
 * @since 1.0.0
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    private static int maxArea(int[] arr){
        int maxarea=0,i=0,j=arr.length-1;
        while (i<j){
            maxarea=Math.max(maxarea,(Math.min(arr[i],arr[j]))*(j-i));
            if (arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxarea;
    }
}