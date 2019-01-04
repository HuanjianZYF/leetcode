package Z21_40;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/4 15:40
 **/
public class NextPermutation31 {

    /**
     * 获取下一个字典序
     * 1234 1243 1324 1342 1423 1432
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        // 找到最后的一个 在后边有大于它的那个位置
        int pos = nums.length - 2;
        for (; pos >= 0; pos--) {
            if (hasBiggerAfter(nums, pos)) {
                break;
            }
        }

        // 如果是全倒序的，排序一下
        if (pos == -1) {
            Arrays.sort(nums);
            return;
        }

        // 找到那个比它大一点点的那个数的位置
        int pos2 = getBigThanPos(nums, pos);

        // 交换两个数的位置
        swapPos(nums, pos, pos2);

        // 将之后的数排序一下
        Arrays.sort(nums, pos + 1, nums.length);
    }

    private void swapPos(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int getBigThanPos(int[] nums, int pos) {
        int result = pos;
        int value = Integer.MAX_VALUE;
        for (int i = pos + 1; i <= nums.length - 1; i++) {
            if (nums[i] > nums[pos] && nums[i] < value) {
                value = nums[i];
                result = i;
            }
        }

        return result;
    }

    private boolean hasBiggerAfter(int[] nums, int pos) {
        for (int i = pos; i <= nums.length - 1; i++) {
            if (nums[i] > nums[pos]) {
                return true;
            }
        }
        return false;
    }
}
