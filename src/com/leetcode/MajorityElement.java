/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MajorityElement
 * Author:   王小手
 * Date:     2019/12/31 14:35
 * Description: 多数元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 〈一句话功能简述〉<br> 
 * 〈多数元素〉
 *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2
 * @author
 * @create 2019/12/31
 * @since 1.0.0
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    private static int majorityElement(int[] nums){
        Arrays.sort(nums);
       return nums[nums.length/2];
    }

    private static int majorityElement2(int[] nums){
        Stack<Integer> stack=new Stack();
        for (int num:nums){
            if (stack.empty()||stack.peek()==num){
                stack.push(num);
            }else{
                stack.pop();
            }
        }
        return stack.peek();
    }

}