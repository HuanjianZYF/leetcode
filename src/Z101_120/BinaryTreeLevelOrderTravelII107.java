package Z101_120;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/29 18:43
 **/
public class BinaryTreeLevelOrderTravelII107 {

    /**
     * 自底向上打印二叉树的节点
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 哈哈一坨代码,思路是弄两个队列，上一层的所有节点放在左边，把这些节点的所有孩子放在右边，然后左右互换
        LinkedList<List<Integer>> resultList = new LinkedList<>();

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        // 初始化数据
        queue1.add(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        resultList.push(rootList);

        boolean jiayou = true;
        while (jiayou) {
            jiayou = false;
            int size = queue1.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <= size - 1; i++) {
                TreeNode node = queue1.remove();
                if (!isLeaf(node)) {
                    if (node.left != null) {
                        queue2.add(node.left);
                        list.add(node.left.val);
                    }
                    if (node.right != null) {
                        queue2.add(node.right);
                        list.add(node.right.val);
                    }
                    jiayou = true;
                }
            }
            if (list.size() > 0) {
                resultList.push(list);
            }

            LinkedList temp = null;
            temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        return resultList;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
