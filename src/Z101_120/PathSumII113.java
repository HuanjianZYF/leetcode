package Z101_120;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 20:00
 **/
public class PathSumII113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> travelList = new ArrayList<>();
        travel(root, sum, travelList, resultList);

        return resultList;
    }

    private void travel(TreeNode node, int sum, List<Integer> travelList, List<List<Integer>> resultList) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            if (sum == node.val) {
                List<Integer> tmp = new ArrayList<>(travelList);
                tmp.add(node.val);
                resultList.add(tmp);
            }
        } else {
            travelList.add(node.val);
            if (node.left != null) {
                travel(node.left, sum - node.val, travelList, resultList);
            }
            if (node.right != null) {
                travel(node.right, sum - node.val, travelList, resultList);
            }
            travelList.remove(travelList.size() - 1);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
