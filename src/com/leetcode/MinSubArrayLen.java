/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MinSubArrayLen
 * Author:   王小手
 * Date:     2019/12/31 16:07
 * Description: 长度最小的子数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈长度最小的子数组〉
 *给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * @author
 * @create 2019/12/31
 * @since 1.0.0
 */
public class MinSubArrayLen {
    public static void main(String[] args) {

    }

    private static int minSubArrayLen(int s,int[] nums){
         int res=Integer.MAX_VALUE;
         if (nums==null) return 0;
         int left=0,right=0,sum=0;
         while (right<nums.length){
             sum+=nums[right];
             while (left<=right && sum>=s){
                 res=Math.min(res,right-left+1);
                 sum-=nums[left];
                 left++;
             }
             right++;
         }
         if (res==Integer.MAX_VALUE) return 0;
         return res;
    }
}