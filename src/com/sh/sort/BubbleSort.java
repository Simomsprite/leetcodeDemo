/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BubbleSort
 * Author:   王小手
 * Date:     2019/10/9 19:31
 * Description: 冒泡排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈冒泡排序〉
 *
 * @author
 * @create 2019/10/9
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1,7,0,9,8,3};
        int[] res = bubble2(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] bubbleSort(int[] data){
        int temp=0;
        for (int i=1;i<data.length;i++){
            for (int j=0;j<data.length-i;j++){
                if (data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
        return data;
    }

    public int[] bubbleSorts(int[] arr){
        int temp;
        for (int i=1;i<arr.length;i++){
            for (int j=arr.length-1;j>i;j--){
                if (arr[j]<arr[j-1]){
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        return arr;
    }

    public static int[] bubble2(int[] arr){
        int temp;
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}