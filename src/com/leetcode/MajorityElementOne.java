/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MajorityElementOne
 * Author:   王小手
 * Date:     2020/1/3 17:06
 * Description: 求众数 II
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈求众数 II〉
 *给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * @author
 * @create 2020/1/3
 * @since 1.0.0
 */
public class MajorityElementOne {
    public static void main(String[] args) {
        int[] arr={1,1,1,3,3,2,2,2,4,4,4,4,9,9,9,9,9,9,6,9,9,9,9,9,9};
        System.out.println(majorutyElement(arr));
    }

    private static List<Integer> majorutyElement(int[] nums){
        List<Integer> list= new ArrayList<>();
        if (nums==null || nums.length==0){
            return list;
        }
        int candidateA=nums[0];
        int candidateB=nums[0];
        int countA=0,countB=0;
        for (int num:nums){
            if (num==candidateA){
                countA++;
                continue;
            }
            if (num==candidateB){
                countB++;
                continue;
            }

            if (countA==0){
                candidateA=num;
                countA++;
                continue;
            }
            if (countB==0){
                candidateB=num;
                countB++;
                continue;
            }
            countA--;
            countB--;
        }

        countA=0;
        countB=0;
        for (int num:nums){
            if (num==candidateA){
                countA++;
            }else if (num==candidateB){
                countB++;
            }
        }
        if (countA>nums.length/3) list.add(candidateA);
        if (countB>nums.length/3) list.add(candidateB);
        return list;

    }
}