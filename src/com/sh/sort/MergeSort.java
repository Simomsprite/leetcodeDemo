/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MergeSort
 * Author:   王小手
 * Date:     2019/10/11 17:00
 * Description: 归并排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.sort;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈归并排序〉
 *
 * @author 你爷爷
 * @create 2019/10/11
 * @since 1.0.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={5,4,6,2,1,7,0,9,8,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] array){
        if (array.length<2) return array;
        int mid=array.length/2;
        int[] left= Arrays.copyOfRange(array,0,mid);
        int[] right=Arrays.copyOfRange(array,mid,array.length);
        return merget(mergeSort(left),mergeSort(right));
    }

    private static int[] merget(int[] left,int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index=0,i=0,j=0;index<result.length;index++){
            if (i>=left.length){
                result[index]=right[j++];
            }else if (j>=right.length){
                result[index]=left[i++];
            }else if (left[i]>right[j]){
                result[index]=right[j];
                j+=1;
            }else {
                result[index]=left[i];
                i+=1;
            }
        }
        return result;
    }
}