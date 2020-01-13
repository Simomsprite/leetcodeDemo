/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CircularArrayLoop
 * Author:   王小手
 * Date:     2020/1/7 15:47
 * Description: 环形数组循环
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈环形数组循环〉
 *给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 *
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 *  
 *
 * 示例 1：
 *
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 *
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 *
 * 输入：[-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 2 的运动是向前的运动，而按索引 2 -> 1 的运动是向后的运动。一个循环中的所有运动都必须沿着同一方向进行。
 *
 * @author
 * @create 2020/1/7
 * @since 1.0.0
 */
public class CircularArrayLoop {
    public static void main(String[] args) {


    }

    public boolean circularArrayLoop(int[] nums) {
        boolean flag = false;
        for (int i = 0, length = nums.length; i < length; i++) {
            int preValue = nums[i];//这也是index移动的值
            if (Math.abs(preValue) == length)//判断移动的值是否为数组的长度,即避免循环
                continue;
//这个三目运算符的意思是看看最终的index是否为负,因为java中被除数如果为负,那么余数也为负,在数组中需要把正和负单独拎出来处理,outer的意思仅仅是和while循环里的做区分
            int outerIndex = (i + preValue) < 0 ? (i + preValue) % length + length : (i + preValue) % length;
            int nowValue = nums[outerIndex];//记录下一个index的值
            int index = outerIndex;//这个值是要和i进行对比
            int count = 0;//这个值是为了能够跳出循环
            //三个条件①跳动的方向要一致②index一致③循环的次数不能超过length
            while (preValue * nowValue > 0 && index != i && count < length) {
                count++;
//迭代式的进行操作,基本上和第一次的处理差不多,可能有一点细节不同
                preValue = nowValue;
                if (Math.abs(preValue) == length)
                    continue;
                int innerIndex = (index + preValue) < 0 ? (index + preValue) % length + length : (index + preValue) % length;
                nowValue = nums[innerIndex];
                if (Math.abs(nowValue) == length)
                    continue;
                index = innerIndex;
                if (index % length == i){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

}