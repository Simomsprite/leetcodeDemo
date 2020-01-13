/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MisssingNumber
 * Author:   王小手
 * Date:     2020/1/6 14:48
 * Description: 缺失数字
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈缺失数字〉
 *给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8

 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr={8,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber2(arr));
    }

    private static int missingNumber(int[] nums){
        Set<Integer> numSet=new HashSet<>();
        for (int num:nums) numSet.add(num);

        int numberCount=nums.length+1;
        for (int number=0;number<numberCount;number++){
            if (!numSet.contains(number)){
                return number;
            }
        }
        return -1;
    }

    private static int missingNumber2(int[] nums){
        int m=nums.length*(nums.length+1)/2;
        int n=0;
        for (int num:nums) n+=num;
        return m-n;
    }
}