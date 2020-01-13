/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BinaryInsertSort
 * Author:   王小手
 * Date:     2019/10/10 15:06
 * Description: 二分插入排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二分插入排序〉
 *
 * @author
 * @create 2019/10/10
 * @since 1.0.0
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1,7,0,9,8,3};
        System.out.println(Arrays.toString(binartInsertSort(arr)));
    }

    public static int[] binartInsertSort(int[] arr){
        if (arr.length==0){
            return arr;
        }
        for (int i=0;i<arr.length;i++){
            int left=0;
            int right=i-1;
            int current=arr[i];
            while(left<=right){
                int mid=left+((right-left)>>1);
                if (arr[mid]>current){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            for (int j=i-1;j>=left;j--){
                arr[j+1]=arr[j];
            }
            arr[left]=current;
        }
        return arr;
    }
}