package Z501_520;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 11:28
 **/
public class FindModeInBinarySearchTree501 {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        fill(root, map);

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i <= list.size() - 1; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private void fill(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        map.merge(node.val, 1, Math::addExact);
        if (node.left != null) {
            fill(node.left, map);
        }
        if (node.right != null) {
            fill(node.right, map);
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
