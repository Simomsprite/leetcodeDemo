/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CombinationSum
 * Author:   王小手
 * Date:     2019/11/28 16:35
 * Description: 组合总和
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
 * 〈组合总和〉
 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]

 * @author
 * @create 2019/11/28
 * @since 1.0.0
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr={2,3,5};
        System.out.println(combinationSum(arr,8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates,target,0,res,new ArrayList<>());
        return res;
    }
    private static void solve(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
        for (int i=start;i<candidates.length;i++){
            if (candidates[i]<=target){
                list.add(candidates[i]);
                if (target-candidates[i]==0){
                    res.add(new ArrayList<>(list));
                }else{
                    int left=target-candidates[i];
                    solve(candidates,left,left>candidates[i] && left<2*candidates[i] ? i+1 : i,res,list);
                }
                list.remove(list.size()-1);
            }else{
                return;
            }
        }
    }
}


























