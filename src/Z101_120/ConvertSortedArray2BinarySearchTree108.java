package Z101_120;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/2 16:06
 **/
public class ConvertSortedArray2BinarySearchTree108 {

    /**
     * 将排序好的数组变成一颗平衡二叉树
     * 简单递归得到
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        if (len == 1) {
            return new TreeNode(nums[0]);
        }
        TreeNode root = new TreeNode(nums[len / 2]);

        int[] leftArray = new int[len / 2];
        int[] rightArray = new int[len - len / 2 - 1];
        System.arraycopy(nums, 0, leftArray, 0, len / 2);
        System.arraycopy(nums, len / 2 + 1, rightArray, 0, len - len / 2 - 1);
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);

        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}
