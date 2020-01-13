/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CombinationSum3
 * Author:   王小手
 * Date:     2019/12/31 17:34
 * Description: 组合总和 III
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈组合总和 III〉
 *
 * @author
 * @create 2019/12/31
 * @since 1.0.0
 */
public class CombinationSum3 {
    public static void main(String[] args) {

    }
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum(int k,int n){
        backAh(k,n,0,1,new LinkedList<>());
        return ans;
    }

    private void backAh(int k, int n, int sum,int begin,LinkedList<Integer> list)
    {
        if (k==0){
            if (n==sum)
                ans.add(new ArrayList<>(list));
            return;
        }
        for (int i=begin;i<10;i++){
            list.add(i);
            backAh(k-1,n,sum+i,i+1,list);
            list.removeLast();
        }
    }

}