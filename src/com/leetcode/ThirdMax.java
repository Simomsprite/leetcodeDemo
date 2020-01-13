/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ThirdMax
 * Author:   王小手
 * Date:     2020/1/6 17:34
 * Description: 第三大的数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈第三大的数〉
 *给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class ThirdMax {
    public static void main(String[] args) {

    }

    private static long MIN = Long.MIN_VALUE;
    public static int thirdMax(int[] nums){
        if (nums==null || nums.length==0) return -1;
        int len=nums.length;

        int one=nums[0];
        long two= MIN;
        long three= MIN;
        for (int i=1;i<len;i++){
            int now=nums[i];
            if (now==one||now==two||now==three) continue;
            if (now>one){
                three=two;
                two=one;
                one=now;
            }else if (now>two){
                three=two;
                two=now;
            }else if (now>three){
                three=now;
            }
        }
        if (three==MIN) return one;
        return (int)three;
    }
}
