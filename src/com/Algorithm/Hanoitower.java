/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Hanoitower
 * Author:   王小手
 * Date:     2019/10/15 16:32
 * Description: hannuota
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

/**
 * 〈分治算法实现汉诺塔〉
 * @create 2019/10/15
 * @since 1.0.0
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(6,'A','B','C');
    }

    private static void hanoitower(int num, char a,char b,char c){
        if (num==1){
            System.out.println("第一个盘从"+a+"->"+c);
        }else{
            hanoitower(num-1,a,c,b);
            System.out.println("第"+num+"个盘从 "+a+"->"+c);
            hanoitower(num-1,b,a,c);
        }
    }
}