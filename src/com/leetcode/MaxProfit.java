/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MaxProfit
 * Author:   王小手
 * Date:     2019/12/12 19:44
 * Description: 买卖股票的最佳时机
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈买卖股票的最佳时机〉
 *输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格
 * @author
 * @create 2019/12/12
 * @since 1.0.0
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] preorder={7,6,4,3,1};
        System.out.println(maxProfit2(preorder));
    }


    private static int maxProfit(int[] prices) {
        int left = 0;
        int right = prices.length - 1;
        int sum = 0;
        while (left < right) {
            for (int i = prices.length-1; i>left; i--) {
                sum = Math.max(prices[i] - prices[left], sum);
            }
            left++;
        }
        return sum;
    }

    private static int maxProfit2(int[] prices){
        int sum=0;
        int minPrice=Integer.MAX_VALUE;
        for (int i=0;i<prices.length;i++){
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }else if (prices[i]-minPrice>sum){
                sum=prices[i]-minPrice;
            }
        }
        return sum;
    }

}