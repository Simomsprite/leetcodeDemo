/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MaxProduct
 * Author:   王小手
 * Date:     2019/12/13 16:32
 * Description: 乘积最大子序列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈乘积最大子序列〉
 *给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * @author
 * @create 2019/12/13
 * @since 1.0.0
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] preorder={0,2};
        System.out.println(maxProduct(preorder));
    }

    private static int maxProduct(int[] nums){
        int max=Integer.MIN_VALUE,imax=1,imin=1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0){
                int temp=imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            max=Math.max(imax,max);
        }
        return max;
    }

}