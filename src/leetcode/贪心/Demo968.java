package leetcode.贪心;


/**
 * @ClassName Demo968
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 10:17
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 */
public class Demo968 {
    int res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        Demo968 demo = new Demo968();
        int res = demo.minCameraCover(root);
        System.out.println(res);
    }

    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if(minCame(root)==0){
            res++;
        }
        return res;
    }
    public int minCame(TreeNode root){
        if(root==null){
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int left=minCame(root.left);
        int  right=minCame(root.right);

        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if(left==2&&right==2){
            //(2,2)
            return 0;
        }else if(left==0||right==0){
            // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            res++;
            return 1;
        }else{
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 那么本节点就是处于被覆盖状态
            return 2;
        }
    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
        this.right = right;
     }
}
