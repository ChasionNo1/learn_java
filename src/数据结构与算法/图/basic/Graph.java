package 数据结构与算法.图.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-20 20:25
 */
public class Graph {
    private ArrayList<String> vertexList; // 存储顶点集合
    private int[][] edges; // 存储邻接矩阵
    private int numOfEdges; // 边的个数
    // 定义boolean数组，记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        for (String s :
                vertexValue) {
            graph.insertVertex(s);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.display();
        System.out.println("深度优先");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先");
        graph.bfs();
        
    }

    public Graph(int n){
        // 初始哈邻接矩阵和顶点集合
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    // 得到第一个邻居节点的下标w
    // 都是从0开始遍历，也就是从头开始找的
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    // 根据前一个邻接结点的下标来获取下一个邻接节点
    // 获取下一个邻居节点
    public int getNextNeighbor(int v1, int v2){
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0){
                return i;
            }
        }
        return -1;
    }

    // 深度优先遍历算法
    // i第一次就是0
    private void dfs(boolean[] isVisited, int i){
        // 首先访问该节点输出
        System.out.print(getValueByIndex(i) + "->");
        // 将节点设置为已访问
        isVisited[i] = true;
        // 获取节点的第一个邻接节点w
        int w = getFirstNeighbor(i);
        // 如果w是存在的
        while (w != -1){
            // 如果w是未被访问的
            if (!isVisited[w]){
                // 就将当前节点代替i，进行递归
                dfs(isVisited, w);
            }
            // 如果节点是访问过的，就访问i节点的第w个节点的下一个节点
            w = getNextNeighbor(i, w);
        }
    }

    // 对dfs进行重载，遍历所有的节点，当前节点如果没有下一个邻居节点，则从当前节点的下一个节点开始
    // 有些图是非连通的
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    // 广度优先搜索
    // 分层搜索
    private void bfs(boolean[] isVisited, int i){
        int u; // 队列头指针
        int w; // 邻接节点w
        // 队列，记录访问节点的顺序
        LinkedList queue = new LinkedList();
        // 访问节点，输出信息
        System.out.print(getValueByIndex(i) + "->");
        // 标记被访问
        isVisited[i] = true;
        // 节点i入队列
        queue.addLast(i);
        // 当队列非空时，继续执行，否则算法结束。
        while (queue.size() != 0){
            // 出队列，取得队头结点u
            u = (int) queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeighbor(u);
            // 节点存在时
            while (w != -1){
                // 当节点未被访问时
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "->");
                    // 节点标记为访问
                    isVisited[w] = true;
                    // 入队列
                    queue.addLast(w);
                }
                // 查找结点u的继w邻接结点后的下一个邻接结点w
                w = getNextNeighbor(u, w);
            }
        }
    }

    // 遍历所有的节点，都进行广度优先搜索
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    /***图中常用的方法*****/
    // 返回图中节点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    // 返回边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    // 返回节点的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    // 返回边的权重
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    // 显示邻接矩阵
    public void display(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }


    // 插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    // 添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
