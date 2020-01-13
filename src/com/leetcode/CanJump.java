/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CanJump
 * Author:   王小手
 * Date:     2019/11/29 18:25
 * Description: 跳跃游戏
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈跳跃游戏〉
 *输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * @author
 * @create 2019/11/29
 * @since 1.0.0
 */
public class CanJump {
    public static void main(String[] args) {
        int[] arr={2,3,1,1,4};
        System.out.println(canJump(arr));
    }

    private static  boolean canJump(int[] nums){
        int leftIndex=nums.length-1;
        for (int i=leftIndex;i>=0;i--){
            if ((i+nums[i])>=leftIndex){
                leftIndex=i;
            }
        }
        if (leftIndex==0){
            return true;
        }else{
            return false;
        }
    }
}