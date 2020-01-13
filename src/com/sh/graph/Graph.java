/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Graph
 * Author:   王小手
 * Date:     2019/9/25 18:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sh.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 创建图
 * @author wxs
 * @create 2019/9/25
 * @since 1.0.0
 */
public class Graph {

    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    //定义一个数组boolean[],记录结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
       int n=5;
       String Vertexs[]={"A","B","C","D","E"};
       Graph graph=new Graph(n);
       for (String vertex:Vertexs){
           graph.insertVetex(vertex);
       }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

        graph.showGraph();
        System.out.println("深度遍历");
        graph.dfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList=new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[5];
    }

    //得到第一个邻接结点的下标
    public int getFirstNetghbor(int index){
        for (int j=0;j<vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    public void dfs(boolean[] isVisited,int i){
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;
        int w=getFirstNetghbor(i);
        while (w!=-1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w=getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载，便利所有的结点，并进行dfs
    public void dfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //对一个节点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited,int i){
        int u;//表示队列的头节点对应的下标
        int w;//邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue=new LinkedList();
        //访问结点，输出结点信息
        System.out.println(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i]=true;
        //将结点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头节点的下标
            u=(Integer) queue.removeFirst();
            //得到第一个邻接结点的下标
            w=getFirstNetghbor(u);
            while (w!=-1){
                //是否访问过
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"=>");
                    isVisited[w]=true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个结点
                w=getNextNeighbor(u,w);
            }
        }
    }

    //遍历所有节点进行广度优先搜索
    public void bfs(){
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //图中常用方法
    //返回结点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //插入结点
    public void insertVetex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

}