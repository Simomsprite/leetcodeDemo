/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProdectExceptSelf
 * Author:   王小手
 * Date:     2020/1/6 14:14
 * Description: 除自身以外数组的乘积
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈除自身以外数组的乘积〉
 *给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class ProdectExceptSelf {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    private static int[] productExceptSelf(int[] nums){
        int res[]= new int[nums.length];
        int k=1;
        for (int i=0;i<res.length;i++){
            res[i]=k;
            k=k*nums[i];
        }
        k=1;
        for (int i=res.length-1;i>=0;i--){
            res[i]=res[i]*k;
            k*=nums[i];
        }
        return res;
    }

}