package Z101_120;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 17:07
 **/
public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        pathStep(root, 0, set);

        return set.contains(sum);
    }

    private void pathStep(TreeNode node, int nodeSum, Set<Integer> set) {
        if (isLeaf(node)) {
            set.add(nodeSum + node.val);
            return;
        }
        if (node.left != null) {
            pathStep(node.left, nodeSum + node.val, set);
        }
        if (node.right != null) {
            pathStep(node.right, nodeSum + node.val, set);
        }
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
