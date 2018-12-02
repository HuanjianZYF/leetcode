package Z101_120;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 16:21
 **/
public class BalancedBinaryTree110 {

    /**
     * 判断一棵树是不是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int leftHight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        return Math.abs(leftHight - rightHeight) <= 1;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = treeHeight(root.left);
        int rightLen = treeHeight(root.right);
        return leftLen > rightLen ? leftLen + 1 : rightLen + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
