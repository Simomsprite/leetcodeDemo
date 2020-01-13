/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ContainsDuplicate
 * Author:   王小手
 * Date:     2020/1/3 14:51
 * Description: 存在重复元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈存在重复元素〉
 *给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @author
 * @create 2020/1/3
 * @since 1.0.0
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        if (nums.length==1){
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private static boolean contains(int[] nums){
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x:nums){
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

}