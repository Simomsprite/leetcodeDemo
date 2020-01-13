/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MoveZeroes
 * Author:   王小手
 * Date:     2020/1/6 15:32
 * Description: 移动零
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈移动零〉
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class MoveZeroes {
    public static void main(String[] args) {

    }

    private static void moveZeroes(int[] nums){
        int zero=0;
        for (int num:nums){
            if (num!=0){
                nums[zero++]=num;
            }
        }
        while (zero<nums.length){
            nums[zero++]=0;
        }
    }
}