/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SearchRange
 * Author:   王小手
 * Date:     2019/11/27 15:42
 * Description: 查找元素的第一个和最后一个位置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;


import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈查找元素的第一个和最后一个位置〉
 *
 * @author
 * @create 2019/11/27
 * @since 1.0.0
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr,8)));
    }

    private static int[] searchRange(int[] nums,int target){
        int[] res=new int[2];
        res[0]=findFirst(nums,target);
        res[1]=findLast(nums,target);
        return res;
    }

    private static int findFirst(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (nums[mid]>target){
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                if (mid==0 || (nums[mid-1]!=target)){
                    return mid;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    private static int findLast(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (nums[mid]>target){
                end=mid-1;
            }else if (nums[mid]<target){
                start=mid+1;
            }else{
                if ((mid == nums.length - 1 || (nums[mid + 1] != target))) {
                    return mid;
                }else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }

}