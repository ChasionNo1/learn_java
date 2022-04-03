package 数据结构与算法.图.最小生成树;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-21 17:11
 */
public class Kruskal {
    private int edgeNum;
    private char[] vertex;
    private int[][] adj;
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public Kruskal(char[] vertex, int[][] adj) {
        int vertexNum = vertex.length;
        this.vertex = new char[vertexNum];
        this.adj = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            //初始化顶点, 复制拷贝的方式
            this.vertex[i] = vertex[i];
            for (int j = 0; j < vertexNum; j++) {
                //初始化边, 使用的是复制拷贝的方式
                this.adj[i][j] = adj[i][j];
            }
        }
        // 统计边的数量
        for (int i = 0; i < vertexNum; i++) {
            for (int j = i + 1; j < vertexNum; j++) {
                if (this.adj[i][j] != INF) {
                    //统计边的条数
                    edgeNum++;
                }
            }
        }
    }

    public void display() {
        for (int[] link :
                adj) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 对边的权值的进行排序，冒泡排序
    private void sortEdge(EData[] eData) {
        for (int i = 0; i < eData.length - 1; i++) {
            for (int j = 0; j < eData.length - 1 - i; j++) {
                if (eData[j].weight > eData[j + 1].weight) {
                    EData temp = eData[j];
                    eData[j] = eData[j + 1];
                    eData[j + 1] = temp;
                }
            }
        }
    }

    // 输入顶点的值，返回顶点的下标
    private int getPosition(char c){
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == c){
                return i;
            }
        }
        return -1;
    }

    // 获取图中边，放到EData[]中，
    public EData[] getEdges(){
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (adj[i][j] != INF){
                    edges[index++] = new EData(vertex[i], vertex[j], adj[i][j]);
                }
            }
        }
        return edges;
    }

    // 获取下标为i顶点的终点，用于后面判断两个顶点是否相同
    // ends:记录了各个顶点对应的重点是哪个，ends数组是在遍历过程中逐步形成的，想不想KMP中的next数组？
    // i表示传入的顶点i对应的下标
    // 返回的是下标i顶点对应的终点的下标
    private int getEnd(int[] ends, int i){
        // 如果不是0，就返回对应位置上的值
        // 这个地方是循环，假设C一开始的终点是D，随着边增加，D的终点是F，那么此时C的终点也是F
        while (ends[i] != 0){
            i = ends[i];
        }
        // 如果是0，就返回本身，自己就是终点
        return i;
    }

    public void kruskal(){
        int index = 0; // 表示最后结果数组的索引
        int[] ends = new int[edgeNum]; // 用于保存已有最小生成树中每个顶点在最小生成树中的终点下标
        // 创建结果数组，保存最后的最小生成树，个数为n-1个，
        EData[] result = new EData[vertex.length - 1];

        // 获取图中所有边的集合
        EData[] edges = getEdges();
        // 对边进行排序
        sortEdge(edges);

        // 遍历edge数组，将边添加到最小生成树中，判断准备加入的边是否形成了回路，如果没有就加入，反之不加。
        for (int i = 0; i < edgeNum; i++) {
            // 获取开端的下标
            int p1 = getPosition(edges[i].start);
            // 获取结尾的下标
            int p2 = getPosition(edges[i].end);
            // 获取开端下标的最小生成树中的终点下标
            //
            int m = getEnd(ends, p1);
            // 获取结尾下标的最小生成树中的终点下标
            int n = getEnd(ends, p2);

//            System.out.println("i" + i);
//            System.out.println(Arrays.toString(ends));
//            System.out.println("p1:" + p1 + ",p2:" + p2);
//            System.out.println("start:" + edges[i].start + ",m:" + m);
//            System.out.println("end:" + edges[i].end + ",n:" + n);
            // 如果不相等，就添加成功
            if (m != n){
                // 将开端节点的最小生成树节点设置为结尾节点的下标
                ends[m] = n;
                result[index++] = edges[i];
            }
        }

        System.out.println("最小生成树为：");
        for (EData data :
                result) {
            System.out.println(data);
        }
    }


}

// 创建一个类EData，它的对象实例就是一条边
class EData {
    char start; // 边的开端
    char end;  // 边的结尾
    int weight; // 边的权重

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}



