/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ViolenceMatch
 * Author:   王小手
 * Date:     2019/10/15 19:29
 * Description: KMP暴力匹配
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈KMP暴力匹配〉
 *
 * @author
 * @create 2019/10/15
 * @since 1.0.0
 */
public class ViolenceMatch {
    public static void main(String[] args) {

    }

    public static int violenceMatch(String s1,String s2){
        char[] chars1 =s1.toCharArray();
        char[] chars2=s2.toCharArray();

        int s1Len=s1.length();
        int s2Len=s2.length();

        int i=0,j=0;
        while (i<s1Len && j<s2Len){
            if (chars1[i]==chars2[j]){
                i++;
                j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }
        if (j==s2Len){
            return i-j;
        }else{
            return -1;
        }
    }
}