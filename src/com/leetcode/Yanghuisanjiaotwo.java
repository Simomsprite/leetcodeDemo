/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Yanghuisanjiaotwo
 * Author:   王小手
 * Date:     2019/12/10 17:26
 * Description: 杨辉三角2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈杨辉三角2〉
 *给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 * 输入: 3
 * 输出: [1,3,3,1]
 * @author
 * @create 2019/12/10
 * @since 1.0.0
 */
public class Yanghuisanjiaotwo {
    public static void main(String[] args) {
        int numRows=5;
        System.out.println(getRow2(numRows));
    }

    private static List<Integer> getRow(int rowIndex){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i=1;i<=rowIndex;i++){
            for (int j=i-1;j>0;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }
            list.add(1);
        }
        return list;

    }
    private static List<Integer> getRow2(int rowIndex){
        List<Integer> list = new ArrayList<>();
        List<Integer> prelist=new ArrayList<>();
        for (int i=0;i<=rowIndex;i++){
            list = new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j==0 || j==i){
                    list.add(1);
                }else{
                    list.add(prelist.get(j-1)+prelist.get(j));
                }
            }
            prelist = list;
        }
        return list;
    }

}