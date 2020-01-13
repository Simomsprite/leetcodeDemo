/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CombinationSum2
 * Author:   王小手
 * Date:     2019/11/28 18:11
 * Description: 组合总和2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈组合总和2〉
 *
 * @author
 * @create 2019/11/28
 * @since 1.0.0
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        System.out.println(combinationSum(arr,8));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先排序，通过排序，后续方便去重
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

     static void backtrack(int[] candidates, int start, int target, List<Integer> output, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) { // 由于是递增序列，当大于target，就不用再回溯
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) { //去重，跟前一个比较，比如相等，那么肯定重复了
                continue;
            }

            output.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], output, res);
            output.remove(output.size() - 1);
        }
    }
}