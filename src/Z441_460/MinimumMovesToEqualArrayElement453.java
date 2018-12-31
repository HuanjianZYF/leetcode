package Z441_460;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/31 17:27
 **/
public class MinimumMovesToEqualArrayElement453 {

    /**
     * 给一个数组，有n个数，每一次都要使n-1个数+1，使每个数都相等需要做多少次
     * 给n-1个数+1 和 给某个数-1 是一模一样的
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int result = 0;
        for (int num : nums) {
            result += num - min;
        }

        return result;
    }
}
