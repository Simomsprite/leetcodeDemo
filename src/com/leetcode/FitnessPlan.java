/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FitnessPlan
 * Author:   王小手
 * Date:     2019/9/29 16:21
 * Description: 健身计划评估
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈健身计划评估〉
 *
 * @author 王学松
 * @create 2019/9/29
 * @since 1.0.0
 */
public class FitnessPlan {
    public static void main(String[] args) {
        int[] a ={3,2};
        FitnessPlan fit=new FitnessPlan();
        System.out.println(fit.fintnessPlan(a,2,0,1));
    }

    public int fintnessPlan(int[] calories,int k,int lower,int upper){
        int count=0;
        int grade=0;
        for (int i=0;i<k;i++) {
            count += calories[i];
        }
        if (count < lower) grade--;
        else if (count > upper) grade++;

        for (int j=0;j<calories.length-k;j++){
            count=count-calories[j]+calories[j+k];
            if (count < lower) grade--;
            else if (count > upper) grade++;
        }
        return grade;
    }
}