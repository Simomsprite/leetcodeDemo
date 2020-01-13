/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BinarySearchNoRec
 * Author:   王小手
 * Date:     2019/10/15 15:51
 * Description: 二分查找非递归实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二分查找非递归实现〉
 *
 * @author
 * @create 2019/10/15
 * @since 1.0.0
 */
public class BinarySearchNoRec {
    public static void main(String[] args) {
        
    }
    
    /**
     * @param: arr 待查找的数组升序排列  target 需要查找的数
     * @return:返回对应下标
     */
    public static int binarySearch(int[] arr,int target){
        int left =0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (arr[mid]==target){
                return  mid;
            }else if (arr[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }

}