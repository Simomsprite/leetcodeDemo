/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: rotateArrayEasy
 * Author:   王小手
 * Date:     2019/12/31 15:13
 * Description: 旋转数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈旋转数组〉
 *给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * @author
 * @create 2019/12/31
 * @since 1.0.0
 */
public class rotateArrayEasy {
    public static void main(String[] args) {

    }

    private static void rotate(int[] nums,int k){
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public static void reverse(int[] nums,int left,int right) {
        while (left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }

}