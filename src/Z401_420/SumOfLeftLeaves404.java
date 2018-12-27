package Z401_420;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 16:54
 **/
public class SumOfLeftLeaves404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || isLeaf(root)) {
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }

        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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
