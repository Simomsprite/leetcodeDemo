/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindDisappearedNumbers
 * Author:   王小手
 * Date:     2020/1/7 15:12
 * Description: 找到所有数组中消失的数字
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈找到所有数组中消失的数字〉
 *给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * @author
 * @create 2020/1/7
 * @since 1.0.0
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {

    }

    private static List<Integer> findDis(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> list = new LinkedList<>();
        for (int i=1;i<=nums.length;i++){
            if (nums[i-1]>0){
                list.add(i);
            }
        }
        return list;
    }
}