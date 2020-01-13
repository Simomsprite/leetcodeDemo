/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MergeArray
 * Author:   王小手
 * Date:     2019/12/5 16:56
 * Description: 合并有序数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈合并有序数组〉
 *初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @author
 * @create 2019/12/5
 * @since 1.0.0
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] arr1={1,2,3,0,0,0};
        int[] arr2={2,5,6};
        int m = 3;
        int n = 3;

        merge(arr1,m,arr2,n);
        System.out.println(Arrays.toString(arr1));
    }

    private static void merge(int[] nums1,int m,int[] nums2,int n){
        int arr1=m-1;
        int arr2=n-1;
        int arr=m+n-1;
        while ((arr1>=0)&&(arr2>=0)){
            nums1[arr--]=(nums1[arr1]<nums2[arr2]) ? nums2[arr2--]:nums1[arr1--];
        }
        System.arraycopy(nums2,0,nums1,0,arr2+1);
    }

}