/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TriangleNumber
 * Author:   王小手
 * Date:     2020/1/9 16:22
 * Description: 有效三角形的个数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈有效三角形的个数〉
 *给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * @author
 * @create 2020/1/9
 * @since 1.0.0
 */
public class TriangleNumber {
    public static void main(String[] args) {

    }

    private static int triangleNumber(int[] nums){
        int count=0;
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            int k=i+2;
            for (int j=i+1;j<nums.length-1 && nums[i]!=0;j++){
                while (k<nums.length && nums[i] + nums[j] >nums[k]){
                    k++;
                }
                count+=k-j-1;
            }
        }
        return count;
    }

    private static int triangleNumber2(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        int res=0;
        for (int i=len-1;i>=2;i--){
            int left=0,right=i-1;
            while (left<right){
                if (nums[left]+nums[right]>nums[i]){
                    res+=right-left;
                    --right;
                }else{
                    ++left;
                }
            }
        }
        return res;
    }


}