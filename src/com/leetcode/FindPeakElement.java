/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FindPeakElement
 * Author:   王小手
 * Date:     2019/12/26 16:34
 * Description: 寻找峰值
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈寻找峰值〉
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 * @author
 * @create 2019/12/26
 * @since 1.0.0
 */
public class FindPeakElement {
    public static void main(String[] args) {

    }

    private static int findPeakElement(int[] nums){
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]>nums[mid+1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private static int findPeakElement2(int[] nums){
        for (int i=0;i<nums.length;i++){
            if (nums[i]>nums[i+1]){
                return i;
            }
        }
        return nums.length-1;
    }
}