/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrimeAlgorithm
 * Author:   王小手
 * Date:     2019/10/21 18:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

import java.util.Arrays;

/**
 * 普利姆算法
 * @author
 * @create 2019/10/21
 * @since 1.0.0
 */
public class PrimeAlgorithm {
    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int verxs=data.length;
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        MGraph mGraph=new MGraph(verxs);
        MinTree minTree=new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);
    }
}

//创建最小生成树->村庄的图
class MinTree{
    /**
     * @param: graph 图对象
     * @param: verxs 图对应的顶点个数
     * @param: data 图的各个顶点的值
     * @param: weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph,int verxs,char data[],int[][] weight ){
        int i,j;
        for (i=0;i<verxs;i++){
            graph.data[i]=data[i];
            for (j=0;j<verxs;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }
    //显示图
    public void showGraph(MGraph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    /**
     * @param: graph 图
     * @param: v 表示从图的第几个顶点开始生成'A'->0,'B'->1...
     */
    public void  prim(MGraph graph,int v){
       //表示标记结点是否被访问过
        int visited[]=new int[graph.verxs];
       /* for (int i=0;i<graph.verxs;i++){
            visited[i]=0;
        }*/
       //把当前结点标记为已访问
        visited[v]=1;
        //h1和h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight=10000;//将minWeight初始成一个大数，后面再遍历过程中，会被替换
        for (int k=1;k<graph.verxs;k++){//因为有graph.verxs顶点，普利姆算法结束后，有graph.verxs-1条边
            //这个是确定每一次生成的子图，和哪个结点的距离最近
            for (int i=0;i<graph.verxs;i++){//i结点表示被访问过的结点
                for (int j=0;j<graph.verxs;j++){//j结点表示还没访问过的结点
                    if (visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minWeight){
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值的最小边)
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值"+minWeight);
            //将当前找到的结点标记为已访问
            visited[h2]=1;
            minWeight=10000;
        }
    }
}

class MGraph{
    int verxs;//表示图的结点个数
    char[] data;//存放结点数据
    int[][] weight;//就是我们的邻接矩阵

    public MGraph(int verxs){
        this.verxs=verxs;
        data=new char[verxs];
        weight=new int[verxs][verxs];
    }
}


