/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrimeNumber
 * Author:   王小手
 * Date:     2019/10/12 10:48
 * Description: 判断101-200之间有多少个素数，并输出所有素数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈判断1-200之间有多少个素数，并输出所有素数〉
 *
 * @author
 * @create 2019/10/12
 * @since 1.0.0
 */
public class PrimeNumber {
    public static void main(String[] args) {
        prime();
    }

    private static void prime(){
       int count=0;
       for (int i=1;i<200;i+=2){
           boolean flag=true;
           for (int j=2;j<=Math.sqrt(i);j++){
               if (i%j==0){
                   flag=false;
                   break;
               }
           }
           if (flag==true){
               count++;
               System.out.println(i);
           }
       }
       System.out.println(count);
    }

}