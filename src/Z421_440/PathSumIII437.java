package Z421_440;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 20:22
 **/
public class PathSumIII437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return step(root, sum, root.val);
    }

    private int step(TreeNode node, int target, int nowValue) {

        int sum = 0;
        if (nowValue == target) {
            sum++;
        }

        if (node.left != null) {
            sum += step(node.left, target, node.left.val) + stepWithNode(node.left, target - nowValue);
        }
        if (node.right != null) {
            sum += step(node.right, target, node.right.val) + stepWithNode(node.right, target - nowValue);
        }

        return sum;
    }

    private int stepWithNode(TreeNode node, int sum) {
        int result = 0;
        if (node.val == sum) {
            result++;
        }
        if (node.left != null) {
            result += stepWithNode(node.left, sum - node.val);
        }
        if (node.right != null) {
            result += stepWithNode(node.right, sum - node.val);
        }
        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
