/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SummaryRanges
 * Author:   王小手
 * Date:     2020/1/3 16:08
 * Description: 汇总区间
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈汇总区间〉
 *给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 * @author
 * @create 2020/1/3
 * @since 1.0.0
 */
public class SummaryRanges {
    public static void main(String[] args) {

    }

    private static List<String> summaryRanges(int[] nums){
        int len= nums.length;
        List<String> list=new ArrayList<>();
        int i=0,j;
        while (i<len){
            String start=nums[i]+"";
            j=i+1;
            if (i==len-1){
                list.add(start);
                break;
            }
            while (j<len){
                if (nums[j]!=nums[j-1]+1){
                    break;
                }
                j++;
            }
            j--;
            if (i==j){
                list.add(start);
            }else{
                start=start+"->"+nums[j];
                list.add(start);
            }
            i=j+1;

        }
        return list;
    }
}