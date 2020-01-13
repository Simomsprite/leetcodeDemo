/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: InsertSort
 * Author:   王小手
 * Date:     2019/7/6 21:22
 * Description: 插入排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈插入排序〉
 *
 * @author 王学松
 * @create 2019/7/6
 * @since 1.0.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1,7,0,9,8,3};
//        insertSort(arr);
        insert_sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            int insertVal=arr[i];
            int insertIndex=i-1;
            while(insertIndex>=0&&insertVal>arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[] insertSort1(int[] arr){
        for (int i=1;i<arr.length;i++){
            int insertVal=arr[i];
            int insertIndex=i-1;
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex!=i){
                arr[insertIndex+1]=insertVal;
            }
        }
        return arr;
    }

    private static int[] insert_sort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int insertVal=arr[i+1];
            int insertIndex=i;
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }
        return arr;
    }
}