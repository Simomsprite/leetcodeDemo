/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Merge
 * Author:   王小手
 * Date:     2019/11/29 19:19
 * Description: 合并区间
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈合并区间〉
 *输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @create 2019/11/29
 * @since 1.0.0
 */
public class Merge {
    public static void main(String[] args) {

    }

    private static int[][] merge(int[][] intervals){
        List<int[]> res=new ArrayList<>();
        if (intervals==null || intervals.length==0) return res.toArray(new int[0][]);
        if (intervals.length <= 1) { return intervals; }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i=1;i<intervals.length;i++){
            int[] one=intervals[i-1];
            int[] two=intervals[i];
            if (two[0]>one[1]){
                res.add(one);
            }
            else if (two[0]<=one[1]){
                two[1]=Math.max(one[1],two[1]);
                two[0]= one[0];
            }
            if (i==intervals.length-1){
                res.add(two);
            }

        }
        return res.toArray(new int[0][]);
    }

}