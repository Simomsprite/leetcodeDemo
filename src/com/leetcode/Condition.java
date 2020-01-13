/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Condition
 * Author:   王小手
 * Date:     2019/10/12 11:19
 * Description: 利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示〉
 *
 * @author
 * @create 2019/10/12
 * @since 1.0.0
 */
public class Condition {
    public static void main(String[] args) {
        condition();
    }

    private static void condition(){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        char grade=n>=90? 'A' : n>=60 ? 'B':'C';
        System.out.println(grade);
    }
}