/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SearchInsert
 * Author:   王小手
 * Date:     2019/11/26 19:12
 * Description: 搜索插入位置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索插入位置〉
 *
 * @author
 * @create 2019/11/26
 * @since 1.0.0
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,8,10,25};
        System.out.println(test(arr,9));
    }
    private static int searchInsert(int[] arr,int target){
        int i=0;
        int j=arr.length-1;
        while (i<=j){
            int mid=(i+j)/2;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]<target){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }

    private static int  test( int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                if (nums[mid] == target) {
                    return mid;
                }
            }
        }
        return i;
    }

}