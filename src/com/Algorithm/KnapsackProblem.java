/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: KnapsackProblem
 * Author:   王小手
 * Date:     2019/10/15 18:18
 * Description: 动态对话实现背包问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

/**
 * 〈动态规划实现背包问题〉
 * @author
 * @create 2019/10/15
 * @since 1.0.0
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w={1,4,3};//物品的重量
        int[] val={1500,3000,2000};//物品的价值
        int m=4;//背包的容量
        int n=val.length;//物品个数

        //为了记录放商品的情况，我们放一个二维数组
        int[][] path=new int[n+1][m+1];

        //创建二维数组，v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
       int[][] v=new int[n+1][m+1];
       //初始化第一行第一列，默认是0
       for (int i=0;i<v.length;i++){
           v[i][0]=0;
       }
       for (int i=0;i<v[0].length;i++){
           v[0][i]=0;
       }

       //根据前面的公式来动态规划处理
        for (int i=1;i<v.length;i++){
            for (int j=1;j<v[0].length;j++){
                if (w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
                    //因为i是从1开始的，因此公式需要调整成下面这段代码
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录背包情况，用if - else来体现公式
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        //输出v
       for (int i=0;i<v.length;i++){
           for (int j=0;j<v[i].length;j++){
               System.out.print(v[i][j]+" ");
           }
           System.out.println();
       }

       System.out.println("++++++++++++++++++++++++++++");
       //输出放入的是那些商品
        int i=path.length-1;
        int j=path[0].length-1;
        while (i>0 && j>0){
            if (path[i][j]==1){
                System.out.println("第"+i+"个商品放入到背包");
                j-=w[i-1];
            }
            i--;
        }
    }
}