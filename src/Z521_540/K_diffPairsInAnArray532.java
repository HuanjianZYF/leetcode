package Z521_540;

import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/10 17:08
 **/
public class K_diffPairsInAnArray532 {

    public int findPairs(int[] nums, int k) {
        int result = 0;

        Arrays.sort(nums);
        int last = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (last == nums[i]) {
                continue;
            }
            if (Arrays.binarySearch(nums,i + 1, nums.length, nums[i] + k) >= 0) {
                result++;
            }
            last = nums[i];
        }

        return result;
    }
}
