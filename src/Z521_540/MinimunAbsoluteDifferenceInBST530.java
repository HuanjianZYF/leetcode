package Z521_540;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 14:37
 **/
public class MinimunAbsoluteDifferenceInBST530 {

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        List<Integer> list = new ArrayList<>();
        collect(root, list);
        Collections.sort(list);
        if (list.size() < 2) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= list.size() - 2; i++) {
            int diff = list.get(i + 1) - list.get(i);
            if (diff < min) {
                min = diff;
            }
        }

        return min;
    }

    private void collect(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            collect(node.left, list);
        }
        if (node.right != null) {
            collect(node.right, list);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
