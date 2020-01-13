/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindUnsortedSubarray
 * Author:   王小手
 * Date:     2020/1/9 14:33
 * Description: 最短无序连续子数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最短无序连续子数组〉
 *给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * @author
 * @create 2020/1/9
 * @since 1.0.0
 */
public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] arr={2, 6, 4, 8, 10, 9, 15};
        System.out.println(find2(arr));
    }

    private static int findUnsortedSubarray(int[] nums){
        int[] twonums=nums.clone();
        Arrays.sort(twonums);
        int start= twonums.length,end=0;
        for (int i=0;i<twonums.length;i++){
            if (twonums[i]!=nums[i]){
                start=Math.min(start,i);
                end=Math.max(end,i);
            }
        }
        return end-start>=0 ? end-start+1:0;
    }

    private static int find2(int[] nums){
        int len=nums.length;
        int rightNum=nums[0];
        int leftNum=nums[len-1];
        int leftIndex=0,rightIndex=-1;
        for (int i=0;i<len;i++){
            if (rightNum>nums[i]){
                rightIndex=i;
            }else{
                rightNum=nums[i];
            }
            if(leftNum<nums[len-i-1]){
                leftIndex=len-i-1;
            }else{
                leftNum=nums[len-i-1];
            }
        }
        return rightIndex-leftIndex+1;
    }
}








