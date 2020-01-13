/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LeaseInterval
 * Author:   王小手
 * Date:     2020/1/9 18:38
 * Description: 621. 任务调度器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈621. 任务调度器〉
 *给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，
 * 或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 1：
 *
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *
 * @author
 * @create 2020/1/9
 * @since 1.0.0
 */

public class LeaseInterval {
    public static void main(String[] args) {

    }

    private int leaseInterval(char[] tasks,int num){
        if (tasks.length <= 1 || num <1) return tasks.length;
        int[] counts=new int[26];
        for (int i=0;i<tasks.length; i++){
            counts[tasks[i]-'A'] ++;
        }
    }
}


