/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Subsets
 * Author:   王小手
 * Date:     2019/12/4 10:55
 * Description: 返回子集
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回子集〉
 *输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author
 * @create 2019/12/4
 * @since 1.0.0
 */
public class Subsets {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        getNums(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    public static void getNums(int[] nums,int start,ArrayList<Integer> temp,List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for (int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            getNums(nums,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}






















