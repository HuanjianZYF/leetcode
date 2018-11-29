package Z101_120;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/29 18:37
 **/
public class MaxDepthOfBinaryTree104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        return leftLen > rightLen ? leftLen + 1 : rightLen + 1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
