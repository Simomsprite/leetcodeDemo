/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FindDuplicatesTwo
 * Author:   王小手
 * Date:     2020/1/7 14:55
 * Description: 数组中重复的数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数组中重复的数据〉
 *给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 * @author
 * @create 2020/1/7
 * @since 1.0.0
 */
public class FindDuplicatesTwo {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        System.out.println(findDup(arr));
    }

    private static List<Integer> findDup(int[] nums){
        Set<Integer> set=new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num:nums)
            if (!set.add(num)){
                list.add(num);
            }
        return list;

    }

}