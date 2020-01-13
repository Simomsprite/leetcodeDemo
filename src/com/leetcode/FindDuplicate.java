/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindDuplicate
 * Author:   王小手
 * Date:     2020/1/6 15:51
 * Description: 寻找重复数
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
 * 〈寻找重复数〉
 *给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class FindDuplicate {
    public static void main(String[] args) {

    }

    private static int findDuplicate(int[] nums){
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    private static int find2(int[] nums){
        Set<Integer> res=new HashSet<>();
        for (int num:nums){
            if (res.contains(num)){
                return num;
            }
            res.add(num);
        }
        return -1;
    }
}