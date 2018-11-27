package Z41_60;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/24 15:12
 **/
public class MaximumSubarray53 {

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray53().maxSubArray(new int[]{-1}));
    }

    /**
     * 求一个数组的子连续数组，使这个子数组的和最大
     * 求出数组的左边能加到的最大和和右边能加到的最大和，两者和最大的为结果
     * 这题居然是easy，我解了2个多小时？？？
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] leftNums = new int[len];
        int[] rightNums = new int[len];

        leftNums[0] = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            leftNums[i] = threeMax(0, nums[i - 1], leftNums[i - 1] + nums[i - 1]);
        }
        rightNums[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightNums[i] = threeMax(0, nums[i + 1], nums[i + 1] + rightNums[i + 1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= len - 1; i++) {
            int oo = leftNums[i] + nums[i] + rightNums[i];
            if (oo > max) {
                max = oo;
            }
        }

        return max;
    }

    private int threeMax(int i, int j, int k) {
        int max = i;
        if (j > max) {
            max = j;
        }
        if (k > max) {
            max = k;
        }

        return max;
    }
}
