package Z81_100;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/29 18:02
 **/
public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
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
