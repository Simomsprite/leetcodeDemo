/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ThreeSum
 * Author:   王小手
 * Date:     2019/11/26 14:05
 * Description: 三数之和
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈三数之和〉
 *
 * @author
 * @create 2019/11/26
 * @since 1.0.0
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    private static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for (int k=0;k<nums.length-2;k++){
            if (nums[k]>0) break;
            if (k>0 && nums[k]==nums[k-1]) continue;
            int i=k+1,j=nums.length-1;
            while (i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if (sum<0){
                    while (i<j && nums[i]==nums[++i]);
                }else if (sum>0){
                    while (i<j && nums[j]==nums[--j]);
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j && nums[i]==nums[++i]);
                    while (i<j && nums[j]==nums[--j]);
                }
            }
        }
        return res;
    }

}