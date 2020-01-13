/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SpiralOrder
 * Author:   王小手
 * Date:     2019/11/29 15:46
 * Description: 旋转矩阵
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈旋转矩阵〉
 *输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @author
 * @create 2019/11/29
 * @since 1.0.0
 */
public class SpiralOrder {
    public static void main(String[] args) {

    }

    private static List<Integer> spiralOrder(int[][] matrix){
        if (matrix==null || matrix.length==0) return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int shang_row=0;
        int xia_row=matrix.length-1;
        int zuo_col=0;
        int you_col=matrix[0].length-1;
        while(shang_row<=xia_row && zuo_col<=you_col){
            for (int i=zuo_col;i<=you_col;i++) res.add(matrix[shang_row][i]);
            shang_row++;
            if (shang_row>xia_row) break;
            for (int i=shang_row;i<=xia_row;i++) res.add(matrix[i][you_col]);
            you_col--;
            if (you_col<zuo_col) break;
            for (int i=you_col;i>=zuo_col;i--) res.add(matrix[xia_row][i]);
            xia_row--;
            for (int i=xia_row;i>=shang_row;i--) res.add(matrix[i][zuo_col]);
            zuo_col++;
        }
        return res;
    }
}