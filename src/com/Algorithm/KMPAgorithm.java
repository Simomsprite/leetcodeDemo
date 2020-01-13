/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: KMPAgorithm
 * Author:   王小手
 * Date:     2019/10/16 18:48
 * Description: KMP算法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈KMP算法〉
 *
 * @author
 * @create 2019/10/16
 * @since 1.0.0
 */
public class KMPAgorithm {
    public static void main(String[] args) {

    }

    /**
     * @param: str1 原字符串
     * @param: str2 子串
     * @param: next 部分匹配表，是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回一个匹配的位置
     */
    //KMP的搜索算法
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j=0;i<str1.length();i++){
            //需要处理str1.charAt(i)!=str2.charAt(j)的情况，去调整J的大小
            //kmp算法核心
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    //获取到一个字符串（子串）的部分匹配值表
    private static int[] kmpNext(String dest){
        //创建next数组保存部分匹配值
        int[] next= new int[dest.length()];
        next[0]=0;//如果dest的长度是1，部分匹配值为0
        for (int i=1,j=0;i<dest.length();i++){
            //当dest.charAt(i)！=dest.charAt(j)
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            //当dest.charAt(i)==dest.charAt(j)满足时，部分匹配值就要+1
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}