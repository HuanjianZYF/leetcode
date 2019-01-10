package Z521_540;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/10 17:23
 **/
public class ConvertBSTToGreaterTree538 {

    /**
     * 根节点: 直接算出右子树节点的和 + 本身
     * 右孩子: 父亲节点的值 - 左子树的和
     * 左孩子: 算出左孩子的右子树的和 + 本身 + 父亲节点的值
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        int oldValue = root.val;
        int bigger = getAllSum(root.right);
        root.val = bigger + root.val;
        dododo(root, bigger, oldValue);
        return root;
    }

    private void dododo(TreeNode node, int parentSum, int parentVal) {
        if (node.right != null) {
            int oldValue = node.right.val;
            node.right.val = parentSum - getAllSum(node.right.left);
            dododo(node.right, node.right.val - oldValue, oldValue);
        }
        if (node.left != null) {
            int oldValue = node.left.val;
            node.left.val = getAllSum(node.left.right) + node.left.val + parentSum + parentVal;
            dododo(node.left, node.left.val - oldValue, oldValue);
        }
    }

    private int getAllSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        sum += node.val;
        if (node.left != null) {
            sum += getAllSum(node.left);
        }
        if (node.right != null) {
            sum += getAllSum(node.right);
        }

        return sum;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
