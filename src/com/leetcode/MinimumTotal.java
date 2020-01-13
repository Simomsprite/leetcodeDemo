/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MinimumTotal
 * Author:   王小手
 * Date:     2019/12/12 19:17
 * Description: 三角形最小路径和
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈三角形最小路径和〉
 *[
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11
 * @author
 * @create 2019/12/12
 * @since 1.0.0
 */
public class MinimumTotal {
    public static void main(String[] args) {

    }

    private static int minimumTotal(List<List<Integer>> triangle){
        int len=triangle.size();
        int[] sum=new int[len+1];
        for (int row=len-1;row>=0;row--){
            for (int i=0;i<=row;i++){
                sum[i]=Math.min(sum[i],sum[i+1])+triangle.get(row).get(i);
            }
        }
        return sum[0];

    }
}