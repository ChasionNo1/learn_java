package 数据结构与算法.图.最短路径;

import java.util.Arrays;

/**
 * @program: test
 * @author: chasion
 * @create: 2022-02-21 21:36
 */
public class Dijkstra {
    public static final int N = 65535;
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] adj = {{N,5,7,N,N,N,2},
                        {5,N,N,9,N,N,3},
                        {7,N,N,N,8,N,N},
                        {N,9,N,N,N,4,N},
                        {N,N,8,N,N,5,4},
                        {N,N,N,4,5,N,6},
                        {2,3,N,N,4,6,N}
                                };
        Graph graph = new Graph(vertex, adj);
        graph.display();
        graph.dijkstra(2);
        graph.showDijkstra();
    }

}

class Graph{
    private char[] vertex; // 顶点数组
    private int[][] adj; // 邻接矩阵
    private VisitedVertex vv; // 表示已经访问过顶点的集合

    public Graph(char[] vertex, int[][] adj){
        this.vertex = vertex;
        this.adj = adj;
    }

    public void display(){
        for (int[] link :
                adj) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @Description: Dijkstra算法实现
     * @Author: chasion
     * @Date: 2022/2/22 10:08
     * @param index: 出发顶点下标
     * @return: void
     **/
    public void dijkstra(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index); //更新index顶点到周围顶点的距离和前驱顶点
        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr(); // 选择并返回新的访问顶点
            update(index); // 更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    public void update(int index){
        int l = 0;
        for (int i = 0; i < adj[index].length; i++) {
            // 出发顶点到index顶点的距离 + 从index顶点到i顶点的距离
            l = vv.getDis(index) + adj[index][i];
            // 如果这个节点i从中间节点index走距离出发节点更近，且这个节点没有被访问，就更新
            if (!vv.isVisited(i) && l < vv.getDis(i)){
                vv.updatePre(i, index);
                vv.updateDis(i, l);
            }
        }

    }

    public void showDijkstra(){
        vv.display();
    }
}

class VisitedVertex{
    // 记录各个顶点是否访问过，1表示访问过，0表示未访问，会动态更行
    public int[] already_arr;
    // 每个下标对应的值为前一个顶点的下标，前驱点
    public int[] pre_visited;
    // 记录出发顶点到其他所有顶点的距离，求得最短距离会更新
    public int[] dis;

    /**
     * @Description:构造器
     * @Author: chasion
     * @Date: 2022/2/22 9:58
     * @param length: 表示顶点的个数
     * @param index: 表示出发顶点的下标
     * @return: null
     **/
    public VisitedVertex(int length, int index){
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        // 初始化dis数组
        Arrays.fill(this.dis, 65535);
        // 设置出发节点为访问过
        this.already_arr[index] = 1;
        // 设置出发节点访问距离为0
        this.dis[index] = 0;
    }

    /**
     * @Description: 判断index是否被访问过
     * @Author: chasion
     * @Date: 2022/2/22 10:02
     * @param index:
     * @return: boolean
     **/
    public boolean isVisited(int index){
        return already_arr[index] == 1;
    }

    /**
     * @Description: 更新出发顶点到index顶点的距离
     * @Author: chasion
     * @Date: 2022/2/22 10:03
     * @param index:
     * @param s:
     * @return: void
     **/
    public void updateDis(int index, int s){
        dis[index] = s;
    }

    /**
     * @Description: 更新pre这个顶点的前驱顶点为index
     * @Author: chasion
     * @Date: 2022/2/22 10:05
     * @param pre:
     * @param index:
     * @return: void
     **/
    public void updatePre(int pre, int index){
        pre_visited[pre] = index;
    }

    /**
     * @Description: 返回出发顶点到index的距离
     * @Author: chasion
     * @Date: 2022/2/22 10:07
     * @param index:
     * @return: int
     **/
    public int getDis(int index){
        return dis[index];
    }

    /**
     * @Description: 找到在一次走中间节点后，未被访问节点更新距离后，其中距离最短的点，将这个点作为下一个中间节点
     * @Author: chasion
     * @Date: 2022/2/22 10:23

     * @return: int
     **/
    public int updateArr(){
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min){
                min = dis[i];
                index = i;
            }
        }
        // 更新index节点为访问过
        already_arr[index] = 1;
        return index;
    }
    /**
     * @Description: 显示三个数组的情况
     * @Author: chasion
     * @Date: 2022/2/22 10:25

     * @return: void
     **/
    public void display(){
        System.out.println("==========================");
        //输出already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();
    }
}