package Z101_120;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 16:51
 **/
public class MinimunOfBinaryTree111 {

    /**
     * 从根节点到叶节点的最小的路径
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int leftMinHeight = minDepth(root.left);
        int rightMinHeight = minDepth(root.right);
        return leftMinHeight < rightMinHeight ? leftMinHeight + 1 : rightMinHeight + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
