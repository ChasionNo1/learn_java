package 数据结构与算法.图.最短路径;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-22 14:11
 */
public class Floyd {
    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        //创建 Graph 对象
        Graph1 graph = new Graph1(vertex.length, matrix, vertex);
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
    }
}

class Graph1{
    private char[] vertex; // 存储顶点的数组
    private int[][] dis; // 保存各个顶点出发到其他顶点的距离数组
    private int[][] pre; // 保存到达目标节点的前驱节点

    public Graph1(int length, int[][] dis, char[] vertex){
        this.vertex = vertex;
        this.dis = dis;
        this.pre = new int[length][length];
        // 对pre数组进行初始化
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public void floyd(){
        int len = 0;
        // 对中间节点进行遍历
        for (int i = 0; i < dis.length; i++) {
            // 从各个节点出发
            for (int j = 0; j < dis.length; j++) {
                // 到达各个顶点
                for (int k = 0; k < dis.length; k++) {
                    len = dis[j][i] + dis[i][k];
                    if (len < dis[j][k]){
                        dis[j][k] = len;
                        pre[j][k] = pre[i][k];
                    }
                }
            }
        }
    }

    // 显示pre数组和dis数组
    public void show() {

        //为了显示便于阅读，我们优化一下输出
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        for (int k = 0; k < dis.length; k++) {
            // 先将pre数组输出的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            // 输出dis数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径是" + dis[k][i] + ") ");
            }
            System.out.println();
            System.out.println();

        }

    }
}
