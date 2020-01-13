/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RemoveDuplicates
 * Author:   王小手
 * Date:     2019/12/5 15:16
 * Description: 删除数组重复项
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈删除数组重复项〉
 *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度
 给定 nums = [1,1,1,2,2,3],

 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * @author
 * @create 2019/12/5
 * @since 1.0.0
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
            int[] arr={1,1,1,2,2,3};

            System.out.println(removeDuplivates(arr));
    }

    public static int removeDuplivates(int[] nums){
        if (nums.length<3){
            return nums.length;
        }
        int indexNums=1;
        for (int i=2;i<nums.length;i++){
            if (nums[i]!=nums[indexNums-1]){
                nums[++indexNums]=nums[i];
            }
        }
        return indexNums+1;
    }
}