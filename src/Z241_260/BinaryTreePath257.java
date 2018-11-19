package Z241_260;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/18 13:53
 **/
public class BinaryTreePath257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        travelNode(root, "", true, result);
        return result;
    }

    private void travelNode(TreeNode node, String s, boolean isHead, List<String> list) {
        String str = isHead ? String.valueOf(node.val) : s + "->" + node.val;

        if (isLeaf(node)) {
            list.add(str);
            return;
        }
        if (node.left != null) {
            travelNode(node.left, str, false, list);
        }
        if (node.right != null) {
            travelNode(node.right, str, false, list);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
