/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SearchSortArray
 * Author:   王小手
 * Date:     2019/11/27 15:04
 * Description: 搜索排序数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索排序数组〉
 *
 * @author
 * @create 2019/11/27
 * @since 1.0.0
 */
public class SearchSortArray {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(searchSortArray(arr,0));
    }

    private static int searchSortArray(int[] arr,int target){
        if (arr==null && arr.length==0){
            return  -1;
        }
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=(start+end)/2;
            if (arr[mid]==target){
                return mid;
            }
            if (arr[start]<=arr[mid]){
                if (target>=arr[start] && target <arr[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if (target<arr[end] && target>arr[mid]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }

}