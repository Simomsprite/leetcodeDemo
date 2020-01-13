/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindMaxConsecutiveOnes
 * Author:   王小手
 * Date:     2020/1/7 15:54
 * Description: 最大连续1的个数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最大连续1的个数〉
 *给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 * @author
 * @create 2020/1/7
 * @since 1.0.0
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {

    }

    private static int findMaxOnes(int[] nums){
        int count=0;
        int maxCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                count+=1;
            }else{
                maxCount=Math.max(maxCount,count);
                count=0;
            }
        }
        return Math.max(maxCount,count);
    }

}