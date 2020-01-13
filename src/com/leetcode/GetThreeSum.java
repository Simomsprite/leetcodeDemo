/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: GetThreeSum
 * Author:   王小手
 * Date:     2019/11/26 16:59
 * Description: 最接近三数之和
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈最接近三数之和〉
 *
 * @author
 * @create 2019/11/26
 * @since 1.0.0
 */
public class GetThreeSum {
    public static void main(String[] args) {
        int[] arr={0,0,0};
        System.out.println(threeSumClosest(arr,1));
    }

    private static int threeSumClosest(int[] nums,int target) {
        if (nums == null && nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, h = nums.length - 1;
            while (j < h) {
                int sum = nums[i] + nums[j] + nums[h];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    h--;
                } else if (sum < target) {
                    j++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

}