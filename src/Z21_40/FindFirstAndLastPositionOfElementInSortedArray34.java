package Z21_40;

import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 18:25
 **/
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int start = index;
        while (start >= 0 && nums[start] == target) {
            start--;
        }
        result[0] = start + 1;

        int end = index;
        while (end <= nums.length - 1 && nums[end] == target) {
            end++;
        }
        result[1] = end - 1;

        return result;
    }
}
