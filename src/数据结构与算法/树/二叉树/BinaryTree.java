package 数据结构与算法.树.二叉树;

/**
 * @Description TODO
 * @Author chasion
 * @Date 2022/2/17 13:30
 **/
public class BinaryTree implements Tree {
    // 表示根节点
    private Node root;

    public Node getRoot() {
        return root;
    }


    @Override
    public Node find(int key) {
        /*
        查找某个节点，我们必须从根节点开始遍历
        1、查找值比当前节点值大，则所搜右子树
        2、查找值等于当前节点值，停止搜索（终止条件）
        3、查找值小于当前节点值，则搜索右子树

        用变量current来保存当前查找的节点，参数key是要查找的值，刚开始查找将根节点赋值到current。
        接在在while循环中，将要查找的值和current保存的节点进行对比。如果key小于当前节点，则搜索当
        前节点的左子节点，如果大于，则搜索右子节点，如果等于，则直接返回节点信息。当整个树遍历完全，
        即current == null，那么说明没找到查找值，返回null。

　　     树的效率：查找节点的时间取决于这个节点所在的层数，每一层最多有2n-1个节点，总共N层共有2n-1个节点，
        那么时间复杂度为O(logN),底数为2。

　      O(logN)，N表示的是二叉树节点的总数，而不是层数。

        * */
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                //当前值比查找值大，搜索左子树
                current = current.leftChild;
            } else if (current.data < key) {
                //当前值比查找值小，搜索右子树
                current = current.rightChild;
            } else
                return current;
        }
        //遍历完整个树没找到，返回null
        return null;
    }

    @Override
    public boolean insert(int data) {
        /*
        要插入节点，必须先找到插入的位置。与查找操作相似，由于二叉搜索树的特殊性，待插入的节点也需要从根节点开始进行比较，
        小于根节点则与根节点左子树比较，反之则与右子树比较，直到左子树为空或右子树为空，则插入到相应为空的位置，在比较的
        过程中要注意保存父节点的信息 及 待插入的位置是父节点的左子树还是右子树，才能插入到正确的位置。

        * */
        Node newNode = new Node(data);
        if (root == null) {
            //当前树为空树，没有任何节点
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.data > data) {
                    current = current.leftChild;
                    if (current == null) {
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 中序遍历
    @Override
    public void infixOrder(Node current) {
        /*
        遍历树是根据一种特定的顺序访问树的每一个节点。比较常用的有前序遍历，中序遍历和后序遍历。
        而二叉搜索树最常用的是中序遍历。

    　　①、中序遍历:左子树——》根节点——》右子树

    　　②、前序遍历:根节点——》左子树——》右子树

    　　③、后序遍历:左子树——》右子树——》根节点
         * */

        if (current != null) {
            infixOrder(current.leftChild);
            System.out.println(current.data + " ");
            infixOrder(current.rightChild);
        }
    }

    // 前序遍历
    @Override
    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.data + " ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }

    }

    // 后序遍历
    @Override
    public void postOrder(Node current) {
        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.println(current.data + " ");
        }
    }

    @Override
    public Node findMax() {
        /*
        这没什么好说的，要找最小值，先找根的左节点，然后一直找这个左节点的左节点，
        直到找到没有左节点的节点，那么这个节点就是最小值。
        同理要找最大值，一直找根节点的右节点，直到没有右节点，则就是最大值。
        * */
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;

        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node cur = root;
        Node minNode = cur;
        while (cur != null) {
            minNode = cur;
            cur = cur.leftChild;
        }
        return minNode;
    }

    /*
    删除节点是二叉搜索树中最复杂的操作，删除的节点有三种情况，前两种比较简单，但是第三种却很复杂。

　　1、该节点是叶节点（没有子节点）

　　2、该节点有一个子节点

　　3、该节点有两个子节点

　　下面我们分别对这三种情况进行讲解。

　　①、删除没有子节点的节点
　　要删除叶节点，只需要改变该节点的父节点引用该节点的值，即将其引用改为 null 即可。要删除的节点依然存在，
    但是它已经不是树的一部分了，由于Java语言的垃圾回收机制，我们不需要非得把节点本身删掉，
    一旦Java意识到程序不在与该节点有关联，就会自动把它清理出存储器。

    删除节点，我们要先找到该节点，并记录该节点的父节点。在检查该节点是否有子节点。
    如果没有子节点，接着检查其是否是根节点，如果是根节点，只需要将其设置为null即可。
    如果不是根节点，是叶节点，那么断开父节点和其的关系即可。

    ②、删除有一个子节点的节点
　　删除有一个子节点的节点，我们只需要将其父节点原本指向该节点的引用，改为指向该节点的子节点即可。

    ③、删除有两个子节点的节点
    当删除的节点存在两个子节点，那么删除之后，两个子节点的位置我们就没办法处理了。
    既然处理不了，我们就想到一种办法，用另一个节点来代替被删除的节点，那么用哪一个节点来代替呢？

　　我们知道二叉搜索树中的节点是按照关键字来进行排列的，某个节点的关键字次高节点是它的中序遍历后继
    节点。用后继节点来代替删除的节点，显然该二叉搜索树还是有序的。（这里用后继节点代替，如果该后继
    节点自己也有子节点，我们后面讨论。）
    那么如何找到删除节点的中序后继节点呢？其实我们稍微分析，这实际上就是要找比删除节点关键值大的节点
    集合中最小的一个节点，只有这样代替删除节点后才能满足二叉搜索树的特性。

　　后继节点也就是：比删除节点大的最小节点。

　　 算法：程序找到删除节点的右节点，(注意这里前提是删除节点存在左右两个子节点，如果不存在则是删除情
    况的前面两种)，然后转到该右节点的左子节点，依次顺着左子节点找下去，最后一个左子节点即是后继节
    点；如果该右节点没有左子节点，那么该右节点便是后继节点。
    需要确定后继节点没有子节点，如果后继节点存在子节点，那么又要分情况讨论了。

　　①、后继节点是删除节点的右子节点
　　这种情况简单，只需要将后继节点表示的子树移到被删除节点的位置即可！
    ②、后继节点是删除节点的右子节点的左子节点

    通过上面的删除分类讨论，我们发现删除其实是挺复杂的，那么其实我们可以不用真正的删除该节点，
    只需要在Node类中增加一个标识字段isDelete，当该字段为true时，表示该节点已经删除，
    反正没有删除。那么我们在做比如find()等操作的时候，要先判断isDelete字段是否为true。
    这样删除的节点并不会改变树的结构。
    * */
    @Override
    public boolean delete(int key) {
        Node cur = root;
        Node parent = root;
        boolean isLeftChild = false;
        // 查找删除值，找不到直接返回false
        while (cur.data != key) {
            parent = cur;
            if (cur.data > key) {
                cur = cur.leftChild;
                isLeftChild = true;
            } else {
                cur = cur.rightChild;
                isLeftChild = false;
            }
            if (cur == null) {
                return false;
            }
        }

        //如果当前节点没有子节点
        if (cur.leftChild == null && cur.rightChild == null) {
            if (cur == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
        }

        //当前节点有一个子节点
        if (cur.leftChild == null && cur.rightChild != null) {
            if (cur == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = cur.rightChild;
            } else {
                parent.rightChild = cur.rightChild;
            }
        } else {
            if (cur == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = cur.leftChild;
            } else {
                parent.rightChild = cur.leftChild;
            }
            return true;
        }
        //当前节点存在两个子节点
        if (cur.leftChild != null && cur.rightChild != null) {
            Node successor = getSuccessor(cur);
            if (cur == root){
                root = null;
            }else if (isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = cur.leftChild;

        }
        return false;
    }

    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node cur = delNode.rightChild;
        while (cur != null){
            successorParent = successor;
            successor = cur;
            cur = cur.leftChild;
        }
        // 后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if (successor != delNode.rightChild){
            // 后继节点的右子节点作为后继节点的父节点的左节点
            successorParent.leftChild = successor.rightChild;
            // 删除节点的右子节点作为后继节点的右子节点
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

}
