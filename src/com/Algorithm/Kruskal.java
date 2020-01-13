/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Kruskal
 * Author:   王小手
 * Date:     2019/10/23 17:18
 * Description: 克鲁斯卡尔算法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Algorithm;

/**
 * 〈一句话功能简述〉<br> 
 * 〈克鲁斯卡尔算法〉
 *
 * @author
 * @create 2019/10/23
 * @since 1.0.0
 */
public class Kruskal {

    private int edgeNum; //边的个数
    private char[] vertexs;//顶点数组
    private int[][] martix;//邻接矩阵
    //使用INF表示两个顶点不能连通,不等于就是有效的
    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int[][] martix={/*A*/ {   0,  12, INF, INF, INF,  16,  14},
                        /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                        /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                        /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                        /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                        /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                        /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        Kruskal kruskalCase=new Kruskal(vertexs,martix);
        kruskalCase.print();
       /* EData[] edges=kruskalCase.getEdges();
        System.out.println(Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println(Arrays.toString(edges));*/
        kruskalCase.kruskal();
}

    //构造器
    public Kruskal(char[] vertexs,int[][] martix){
        //初始化顶点和边的个数
        int vlen=vertexs.length;
        //初始化顶点
        this.vertexs=new char[vlen];
        for(int i=0;i<vertexs.length;i++){
            this.vertexs[i]=vertexs[i];
        }
        //初始化边
        this.martix=new int[vlen][vlen];
        for (int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                this.martix[i][j]=martix[i][j];
            }
        }
        for (int i=0;i<vlen;i++){
            for (int j=i+1;j<vlen;j++){
                if (this.martix[i][j]!=INF){
                    edgeNum++;
                }
            }
        }
    }

    //算法核心代码
    public void kruskal(){
        int index=0;//表示最后结果数组的索引
        int[] ends=new int[edgeNum];//用于保存已有最小生成树中的每个顶点在最小生成树中的终点
        //创建结果数组，保存最后的最小生成树
        EData[] rets=new EData[edgeNum];
        //获取图中所有的边的集合
        EData[] edges=getEdges();
        //按照边的权值大小进行排序（从小到大）
        sortEdges(edges);
        //遍历edges数组，将边添加到最小生成树时，判断准备加入的边是否形成了回路，如果没有就加入rets，否则不能加入
        for (int i=0;i<edgeNum;i++){
            //获取第一个顶点
            int p1=getPosition(edges[i].start);
            //获取第二个顶点
            int p2=getPosition(edges[i].end);
            //获取p1这个顶点在已有的最小生成树中对应的终点是哪一个
            int m=getEnd(ends,p1);
            //获取p2这个顶点在已有的最小生成树中对应的终点是哪一个
            int n=getEnd(ends,p2);
            //是否构成回路
            if (m!=n){
                ends[m]=n;//设置m在已有最小生成树的终点
                rets[index++]=edges[i];//有一条边加入到rets数组
            }
        }
        //统计并打印最小生成树，输出rets
        System.out.println("最小生成树=");
        for (int i=0;i<index;i++){
            System.out.println(rets[i]);
        }
    }

    public void print(){
        System.out.println("邻接矩阵为： \n");
        for (int i=0;i<vertexs.length;i++){
            for (int j=0;j<vertexs.length;j++){
                System.out.printf("%-12d\t",martix[i][j]);
            }
            System.out.println();
        }
    }
    //对边进行排序处理，冒泡排序
    private void sortEdges(EData[] eData){
        for (int i=0;i<eData.length-1;i++){
            for (int j=0;j<eData.length-1-i;j++){
                if (eData[j].weight>eData[j+1].weight){
                    EData temp=eData[j];
                    eData[j]=eData[j+1];
                    eData[j+1]=temp;
                }
            }
        }
    }

    /**
     * @param: ch 顶点的值，比如'A','B'
     * @return: 返回ch顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch){
        for (int i=0;i<vertexs.length;i++){
            if (vertexs[i]==ch){
                return i;
            }
        }
        return -1;
    }

    /**
     * 功能：获取图中的边，放到EData[]数组中，后面我们需要遍历该数组
     * 是通过martix零接矩阵来获取
     * EData[]形式[['A','B',12],['B','F',7]...]
     * @param:
     * @return:
     */
    private EData[] getEdges(){
        int index=0;
        EData[] edges=new EData[edgeNum];
        for (int i=0;i<vertexs.length;i++){
            for (int j=i+1;j<vertexs.length;j++){
                if (martix[i][j]!=INF){
                    edges[index++]=new EData(vertexs[i],vertexs[j],martix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于后面判断两个顶点的终点是否相同
     * @param:  ends这个数组记录了各个顶点对应的终点是哪个   i表示传入的顶点对应的下标
     * @return: 返回的就是下边为i的这个垫高点对应的终点对应的下标
     */
    private int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }
}

//创建一个类EData,它的对象实列就表示一条边
class EData{
    char start;//边的起点
    char end;//边的终点
    int weight;//边的权值

    //构造器
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    //重写toString，便于输出边
    @Override
    public String toString() {
        return "EData{" +
                "<" + start +
                "," + end +
                ">"+"=" + weight +
                '}';
    }
}