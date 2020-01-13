/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SubarraySum
 * Author:   王小手
 * Date:     2020/1/7 18:09
 * Description: 560. 和为K的子数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈560. 和为K的子数组〉
 *给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * @author
 * @create 2020/1/7
 * @since 1.0.0
 */
public class SubarraySum {
    public static void main(String[] args) {

    }

    private static int subarraySum(int[] nums,int k){
       int count =0,sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }
}