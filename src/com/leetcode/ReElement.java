/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ReElement
 * Author:   王小手
 * Date:     2019/11/26 18:40
 * Description: 删除数组元素
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈删除数组元素〉
 *
 * @author
 * @create 2019/11/26
 * @since 1.0.0
 */
public class ReElement {
    public static void main(String[] args) {
        int[] arr={3,2,2,3};
        System.out.println(removeElement(arr,3));
    }

    private static int removeElement(int[] arr,int target){
       int i=0;
       int n= arr.length;
       while (i<n){
           if (arr[i]==target){
               arr[i]=arr[n-1];
               n--;
           }else{
               i++;
           }
       }
       return n;
    }
}