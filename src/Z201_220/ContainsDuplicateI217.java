package Z201_220;

import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/15 14:15
 **/
public class ContainsDuplicateI217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }
}
