/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Generate
 * Author:   王小手
 * Date:     2019/12/10 16:49
 * Description: 杨辉三角
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈杨辉三角〉
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @author
 * @create 2019/12/10
 * @since 1.0.0
 */
public class Generate {
    public static void main(String[] args) {
        int numRows=5;
        System.out.println(generate(numRows));
    }

    private static List<List<Integer>> generate(int numRows){
        List<List<Integer>>  dList=new ArrayList<List<Integer>>();
        if (numRows == 0){
            return dList;
        }

        dList.add(new ArrayList<>());
        dList.get(0).add(1);

        for (int i=1;i<numRows;i++){
            List<Integer> xList=new ArrayList<>();
            List<Integer> xsList=dList.get(i-1);

            xList.add(1);
            for (int j=1;j<i;j++){
                xList.add(xsList.get(j)+xsList.get(j-1));
            }
            xList.add(1);
            dList.add(xList);
        }
        return dList;
    }

}