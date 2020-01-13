/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SearchSpinSortArray
 * Author:   王小手
 * Date:     2019/12/5 15:40
 * Description: 搜索旋转排序数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索旋转排序数组2〉
 *输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * @author
 * @create 2019/12/5
 * @since 1.0.0
 */
public class SearchSpinSortArray {
    public static void main(String[] args) {

    }

    private static  boolean search(int[] nums,int target){
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[left] < nums[mid]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return false;
    }
}