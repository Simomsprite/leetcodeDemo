/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DijkstraAlgorithm
 * Author:   王小手
 * Date:     2019/10/24 17:04
 * Description: 迪杰斯特拉算法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈迪杰斯特拉算法〉
 *
 * @author
 * @create 2019/10/24
 * @since 1.0.0
 */
public class DijkstraAlgorithm
{
    public static void main(String[] args) {
        char[] vertex={'A','B','C','D','E','F','G'};
        int[][] matrix=new int[vertex.length][vertex.length];
        final int N=655355;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};

        Graph graph=new Graph(vertex,matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();
    }

}

class Graph{
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private VisitedVertex visitedVertex;//已经访问的顶点的集合

    //构造器
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //显示结果
    public void showDijkstra(){
        visitedVertex.show();
    }

    //显示图
    public void showGraph(){
        for (int[] link:matrix){
            System.out.println(Arrays.toString(link));
        }
    }

    //迪杰斯特拉算法
    public void dsj(int index){//index:出发顶点对应的下标
        VisitedVertex visitedVertex= new VisitedVertex(vertex.length,index);
        update(index);//更新index顶点到周围顶点的距离和前驱顶点
        for (int j=1;j<vertex.length;j++){
            index=visitedVertex.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    //

    //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index){
        int len=0;
        //根据遍历我们的邻接矩阵的matrix[index]行
        for (int j=0;j<matrix[index].length;j++){
            //len含义是出发顶点到index顶点的距离+从index顶点到j顶点的距离的和
            len=visitedVertex.getDis(index)+matrix[index][j];
            //如果J顶点没有被访问过，并且len小于出发顶点的距离，就需要更新
            if (!visitedVertex.in(j) && len<visitedVertex.getDis(j)){
                visitedVertex.updatePre(j,index);//更新J顶点的前驱为index顶点
                visitedVertex.updateDis(j,len);//更新出发点到J顶点的距离
            }
        }
    }
}

//已访问顶点集合
class VisitedVertex{
    public int[] already_arr;//记录各个顶点是否访问过 1表示访问过，0未访问，会动态更新
    public int[] pre_visited;//每个下标对应的值为前一个顶点下标，会动态更新
    public int[] dis;//记录出发顶点到其他所有顶点的距离，比如G为出发顶点，就会记录G到其他顶点的距离，会动态更新，求的最短距离就会存放到dis
/**
 * @param: index:出发顶点对应的下标，比如G点，下标就是6
 * @param: length:表示顶点的个数
 * @return:
 */
    public VisitedVertex(int length,int index) {
        this.already_arr = new int[length];
        this.pre_visited=new int[length];
        this.dis=new int[length];
        //初始化，dis数组
        Arrays.fill(dis,655355);
        this.already_arr[index]=1;//设置出发顶点被访问过
        this.dis[index]=0;//设置出发顶点的访问距离为0
    }

    /**
     *判断index顶点是否被访问过
     *  @param: index
     * @return: 如果访问过，就返回true,否则返回false
     */
    public boolean in(int index){
        return already_arr[index]==1;
    }

    /**
     * 更新出发顶点到index顶点的距离
     * @param: index  len
     * @return:
     */
    public void updateDis(int index,int len){
        dis[index]=len;
    }

    /**
     *更新Pre这个顶点的前驱顶点为index的顶点
     *  @param:
     * @return:
     */
    public void updatePre(int pre,int index){
        pre_visited[pre]=index;
    }

    /**
     * 返回出发顶点到index顶点的距离
     * @param:
     * @return:
     */
    public int getDis(int index) {
         return dis[index];
    }

    /**
     * 继续选择并返回新的访问顶点，比如这里的G完后，就是A点作为新的访问顶点（注意不是出发顶点）
     * @param:
     * @return:
     */
    public int updateArr(){
        int min=65535,index=0;
        for (int i = 0; i<already_arr.length;i++){
            if (already_arr[i]==0 && dis[i]<min){
                min=dis[i];
                index=i;
            }
        }
        //更新index顶点被访问过
        already_arr[index]=1;
        return index;
    }

    //显示最后的结果,即将三个数组的情况输出
    public void show(){
        System.out.println("==========");
        //输出already_arr
        for (int i:already_arr){
            System.out.print(i+" ");
        }
        System.out.println();
        //输出pre_visited
        for (int i:pre_visited){
            System.out.print(i+" ");
        }
        System.out.println();
        //输出dis
        for (int i:dis){
            System.out.print(i+" ");
        }

    }
}
