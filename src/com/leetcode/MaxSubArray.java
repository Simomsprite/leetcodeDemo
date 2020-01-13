/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MaxSubArray
 * Author:   王小手
 * Date:     2019/11/28 19:12
 * Description: 最大子序和
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最大子序和〉
 *输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author
 * @create 2019/11/28
 * @since 1.0.0
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] nums){
        int sum=0;
        int res=0;
        for (int i=1;i<nums.length;i++){
            if (sum<=0){
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
             res=sum> res ?sum : res;
        }
        return res;
    }
}