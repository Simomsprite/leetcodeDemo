/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SubsetsWithDupTwo
 * Author:   王小手
 * Date:     2019/12/5 17:21
 * Description: 子集 II
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈子集 II〉
 *给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * @author
 * @create 2019/12/5
 * @since 1.0.0
 */
public class SubsetsWithDupTwo {
    public static void main(String[] args) {

    }

    private static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        getAns(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    private static void getAns(int[] nums,int start,ArrayList<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++){
            if (i>start && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            getAns(nums,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }


}