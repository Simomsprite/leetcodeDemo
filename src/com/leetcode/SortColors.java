/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SortColors
 * Author:   王小手
 * Date:     2019/12/3 18:48
 * Description: 颜色排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈颜色排序〉
 *给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 示例:
 *输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * @author
 * @create 2019/12/3
 * @since 1.0.0
 */
public class SortColors {
    public static void main(String[] args) {

    }

    private static void sortColors(int[] nums){
        int start = 0; //指向开头最后一个0元素的后一个元素
        int end = nums.length-1; //指向末尾第一个2元素的前一个元素
        int i = 0; //遍历整个数组
        int temp = 0; //辅助变量，用于交换
        while(i <= end) {
            if(nums[i] == 1) {
                //如果当前元素为1，则不改变位置，遍历下一个元素
                i++;
            }else if(nums[i] == 0) {
                //如果当前元素为0，则与start元素交换，start和i后移一位
                temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start++;
                i++;   // 因为左边一定是都扫描过的, nums[i]的的值是0。一定要后移一位继续扫描。
            }else {  //nums[i] == 2
                //如果当前元素为2，则与end元素交换，end前移一位
                temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;  // 右边交换完，nums[i]是之前的nums[end]的值，这个值是没有被扫描过的，所以需要继续判断nums[i]的值。
            }
        }
    }
}