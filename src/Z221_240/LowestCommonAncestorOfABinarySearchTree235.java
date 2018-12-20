package Z221_240;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/20 14:35
 **/
public class LowestCommonAncestorOfABinarySearchTree235 {

    /**
     * 获取BST的LCA
     * 获取到p 和 q的路径 然后找到最后的那个公共节点即可
     *
     * @param root 一棵BST
     * @param p 一个节点
     * @param q 另一个节点
     * @return LCA
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> list1 = getPath(root, p);
        List<TreeNode> list2 = getPath(root, q);

        return getLastSameNode(list1, list2);
    }

    private TreeNode getLastSameNode(List<TreeNode> list1, List<TreeNode> list2) {
        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list2.contains(list1.get(i))) {
                return list1.get(i);
            }
        }
        return null;
    }

    /**
     * 获得路径
     * @param root 树
     * @param node 节点
     * @return
     */
    private List<TreeNode> getPath(TreeNode root, TreeNode node) {
        List<TreeNode> resultList = new ArrayList<>();

        search(root, node, resultList);
        return resultList;
    }

    private boolean search(TreeNode root, TreeNode node, List<TreeNode> list) {
        // 递归出口
        list.add(root);
        if (root == node) {
            return true;
        }

        if (root.left != null && search(root.left, node, list)) {
            return true;
        }
        if (root.right != null && search(root.right, node, list)) {
            return true;
        }
        list.remove(root);
        return false;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
