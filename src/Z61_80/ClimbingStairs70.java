package Z61_80;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/28 19:31
 **/
public class ClimbingStairs70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i - 1] = nums[i - 2] + nums[i - 3];
        }
        return nums[n - 1];
    }
}
