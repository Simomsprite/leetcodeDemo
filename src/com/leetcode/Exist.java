/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Exist
 * Author:   王小手
 * Date:     2019/12/5 11:29
 * Description: 单词搜索
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈单词搜索〉
 *给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 *board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * @author
 * @create 2019/12/5
 * @since 1.0.0
 */
public class Exist {
    public static void main(String[] args) {


    }

    private static boolean exist(char[][] board,String word){
        if (word.length()==0) return true;
        int m=board.length;
        if (m==0) return false;
        int n=board[0].length;
        if (n==0) return false;
        boolean[][] visited=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j]==word.charAt(0) && existChar(board,word,0,i,j,visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean existChar(char[][] board,String word,int start,int i,int j,boolean[][] visited){
        if (start==word.length()) return  true;
        if (i<0 || i==board.length || j<0 || j==board[0].length) return false;
        if (visited[i][j] || (board[i][j] != word.charAt(start))) return false;
        visited[i][j]=true;
        if (existChar(board,word,start+1,i+1,j,visited)
                ||existChar(board,word,start+1,i-1,j,visited)
                ||existChar(board,word,start+1,i,j+1,visited)
                ||existChar(board,word,start+1,i,j-1,visited)
        ) return true;
        visited[i][j]=false;
        return false;
    }
}