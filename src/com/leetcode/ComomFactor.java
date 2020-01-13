/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ComomFactor
 * Author:   王小手
 * Date:     2019/10/12 11:26
 * Description: 输入两个正整数m和n，求其最大公约数和最小公倍数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈输入两个正整数m和n，求其最大公约数和最小公倍数〉
 *
 * @author
 * @create 2019/10/12
 * @since 1.0.0
 */
public class ComomFactor {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        ComomFactor comomFactor=new ComomFactor();
        int number=comomFactor.comFactor(n,m);
        System.out.println(number);
        System.out.println(n*m/number);
    }

    private int comFactor(int n,int m){
        if (n<m){
            int t=m;
            m=n;
            n=t;
        }
        while (m!=0){
            if (n==m){
                return n;
            }
            int x=m;
            m=n%m;
            n=x;
        }
        return n;
    }
}