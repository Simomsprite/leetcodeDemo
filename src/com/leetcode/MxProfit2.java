/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MxProfit2
 * Author:   王小手
 * Date:     2019/12/13 14:31
 * Description: 买卖股票的最佳时机 II
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈买卖股票的最佳时机 II〉
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author
 * @create 2019/12/13
 * @since 1.0.0
 */
public class MxProfit2 {
    public static void main(String[] args) {
        int[] preorder={1, 7, 5, 3, 6, 20};
        System.out.println(maxProfit2(preorder));
    }

    private static int maxProfit(int[] prices){
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    private static int maxProfit2(int[] prices){
        int i=1;
        int minPrice=prices[0],maxPrice=prices[0];
        int sum=0;
        while (i<prices.length){
            while (i<prices.length && prices[i]<=prices[i-1]){
                minPrice=prices[i];
                i++;
            }
            while (i<prices.length && prices[i]>=prices[i-1]){
                maxPrice=prices[i];
                i++;
            }
            sum+=maxPrice-minPrice;
        }
        return sum;
    }


}