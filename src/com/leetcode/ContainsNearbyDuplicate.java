/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ContainsNearbyDuplicate
 * Author:   王小手
 * Date:     2020/1/3 15:21
 * Description: 存在重复元素 II
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈存在重复元素 II〉
 *给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k
 *示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * @author
 * @create 2020/1/3
 * @since 1.0.0
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {

    }

    public static boolean containsNearbyDuplicate(int[] nums,int k){
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }



}