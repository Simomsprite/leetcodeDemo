/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ShellSort
 * Author:   王小手
 * Date:     2019/10/11 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈希尔排序〉
 *
 * @author
 * @create 2019/10/11
 * @since 1.0.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1,7,0,9,8,3};
        System.out.println(Arrays.toString(shell_sort3(arr)));
    }

    private static int[] shellSort(int[] arr){
        int n=arr.length;
        int h=1;
        while (h<n/3){
            h=3*h+1;
        }
        while (h>=1){
            for (int i=h;i<n;i++){
                for (int j=i;j>=h && (arr[j]<arr[j-h]);j-=h){
                    int temp=arr[j];
                    arr[j]=arr[j-h];
                    arr[j-h]=temp;
                }
            }
            h/=3;
        }
        return arr;
    }

    private static int[] shellSort2(int[] array){
        int len=array.length;
        int temp;
        int gap=len/2;
        while(gap>0){
            for (int i=gap;i<len;i++){
                temp=array[i];
                int preIndex=i-gap;
                while (preIndex>=0 && array[preIndex]>temp){
                    array[preIndex+gap]=array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=temp;
            }
            gap/=2;
        }
        return array;
    }

    private static int[] shell_sort3(int[] arr){
        if (arr==null){
            return arr;
        }
        int len = arr.length;
        int k=len/2;
        while (k>0) {
            for (int i = k; i < len; i++) {
                int insertVal = arr[i];
                int insertIndex = i-k;
                while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                    arr[insertIndex+k] = arr[insertIndex];
                    insertIndex -= k;
                }
                arr[insertIndex+k] = insertVal;
            }
            k/=2;
        }
        return arr;
    }
}