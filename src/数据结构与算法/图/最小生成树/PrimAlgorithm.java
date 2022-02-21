package 数据结构与算法.图.最小生成树;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-21 14:07
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};
        MGraph graph = new MGraph(vertex);
        MinTree tree = new MinTree();
        tree.createGraph(graph, vertex, data, weight);
        tree.display(graph);
        tree.prim(graph, 0);
    }
}

// 创建最小生成树
class MinTree {
    public void createGraph(MGraph mGraph, int vertex, char[] data, int[][] weight) {
        for (int i = 0; i < vertex; i++) {
            mGraph.data[i] = data[i];
            for (int j = 0; j < vertex; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void display(MGraph mGraph) {
        for (int[] link : mGraph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    // prim算法
    public void prim(MGraph graph, int index) {
        // 标记顶点是否被访问
        boolean[] isVisited = new boolean[graph.vertex];
        // 记录每次的代价最小路径
        char[][] path = new char[graph.vertex - 1][2];
        // 记录路径的指针
        int k = 0;
        // 记录总的代价
        int cost = 0;
        // 创建V，VU集合，V是连通网的顶点集合，U是最小生成树的顶点集合，VU是VU之间的差集，
        ArrayList<Character> V = new ArrayList<>();
        ArrayList<Character> VU = new ArrayList<>();
        for (char c :
                graph.data) {
           V.add(c);
           VU.add(c);
        }
        ArrayList<Character> U = new ArrayList<>();

        while (VU.size() > 1){
            // 将顶点i取出放在U集合中，
            U.add(VU.get(index));
            VU.remove(index);

            // 找U中顶点与VU顶点之间存在边的所有情况
            int minCost = 10000;
            for (int i = 0; i < U.size(); i++) {
                for (int j = 0; j < VU.size(); j++) {
                    // 由于列表是动态变化的，使用元素匹配
                    // 即求AB之间的path cost，而不是求01之间的path cost
                    int u_index = V.indexOf(U.get(i));
                    int vu_index = V.indexOf(VU.get(j));
                    if (graph.weight[u_index][vu_index] < minCost){
                        minCost = graph.weight[u_index][vu_index];
                        index = j;
                        path[k][0] = U.get(i);
                        path[k][1] = VU.get(j);
                    }
                }
            }
            cost += minCost;
            k++;
        }

        System.out.println("cost:" + cost);
        for (char[] link: path
        ){
            System.out.println(Arrays.toString(link));
        }
    }
}


class MGraph {
    int vertex;
    char[] data;
    int[][] weight;

    public MGraph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}
