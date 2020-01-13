/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PlusOne
 * Author:   王小手
 * Date:     2019/12/3 14:26
 * Description: 加一
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈加一〉
 *给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头
 *输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * @author
 * @create 2019/12/3
 * @since 1.0.0
 */
public class PlusOne {
    public static void main(String[] args) {

    }

    private int[] plusOne(int[] digits){
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}