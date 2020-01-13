/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TwoSum
 * Author:   王小手
 * Date:     2019/12/30 19:46
 * Description: 两数之和 II - 输入有序数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈两数之和 II - 输入有序数组〉
 *给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @author
 * @create 2019/12/30
 * @since 1.0.0
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    private static int[] twoSum(int[] numbers,int target){
        if(numbers==null) return null;
        int i=0 ,j=numbers.length-1;
        while (i<j){
            int sum=numbers[i]+numbers[j];
            if (sum==target){
                return new int[]{i+1,j+1};
            }else if (sum<target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

}