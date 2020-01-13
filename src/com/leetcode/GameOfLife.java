/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GameOfLife
 * Author:   王小手
 * Date:     2020/1/6 16:27
 * Description: 生命游戏
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.leetcode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈生命游戏〉
 *根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *输入:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * @author
 * @create 2020/1/6
 * @since 1.0.0
 */
public class GameOfLife {
    public static void main(String[] args) {

    }

    private static void gameOfLife(int[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                board[i][j]=checkLoc(board,i,j);
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j = 0; j<board[0] .length;j++){
                board[i][j]=board[i][j]==1 || board[i][j] == -2 ? 1:0;
            }
        }
    }

    private static int checkLoc(int[][] board, int i, int j) {
        int count = 0;
        int left=Math.max(j-1,0);
        int right=Math.min(j+1,board[i].length-1);
        int top=Math.max(i-1,0);
        int bottom=Math.min(i+1,board.length-1);
        for (int x=top;x<=bottom;x++){
            for (int y=left;y<=right;y++){
                count = board[x][y]==1 || board[x][y] == -1 ? count + 1 : count;
            }
        }
        return board[i][j] == 1 ? (count == 3 || count ==4 ? 1 : -1) : (count ==3 ? -2 :0);
    }





}