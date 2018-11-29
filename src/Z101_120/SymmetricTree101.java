package Z101_120;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/29 18:16
 **/
public class SymmetricTree101 {

    /**
     * 判断一棵树是不是左右对称的
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return twoPath(root.left, root.right);
    }

    private boolean twoPath(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        if (!twoPath(root1.left, root2.right) || !twoPath(root1.right, root2.left)) {
            return false;
        }

        return true;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
