package Z221_240;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/20 14:10
 **/
public class InvertBinaryTree226 {

    /**
     * 使二叉树左右翻转
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
