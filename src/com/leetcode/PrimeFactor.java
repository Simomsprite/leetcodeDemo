/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrimeFactor
 * Author:   王小手
 * Date:     2019/10/12 11:09
 * Description: 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5〉
 *
 * @author
 * @create 2019/10/12
 * @since 1.0.0
 */
public class PrimeFactor {
    public static void main(String[] args) {
        primeFactor();
    }

    private static void primeFactor(){
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int k=2;
        while (n>=k){
            if (n==k){
                System.out.println(k);
                break;
            }else if (n%k==0){
                System.out.println(k);
                n=n/k;
            }else{
                k++;
            }
        }
    }
}