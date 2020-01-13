/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SelectSort
 * Author:   王小手
 * Date:     2019/10/9 19:07
 * Description: 选择排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈选择排序〉
 *
 * @author 爸爸的爸爸是爷爷
 * @create 2019/10/9
 * @since 1.0.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1,7,0,9,8,3};
        int[] res = select_sort2(arr);
        System.out.println(Arrays.toString(res));

    }

    public static int[] select_sort(int[] data){
        int temp=0;
        for (int i=0;i<data.length-1;i++){
            for (int j=i+1;j<data.length;j++){
                if (data[j]<data[i]){
                    temp=data[j];
                    data[j]=data[i];
                    data[i]=temp;
                }
            }
        }
        return data;
    }

    private int[] select_sorts(int[] arr){
        int temp=0;
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                }
            }
        }
        return arr;
    }

    private static int[] select_sort2(int[] arr){
        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }

}