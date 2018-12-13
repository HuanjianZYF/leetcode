package Z21_40;

import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/13 9:47
 **/
public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray33().search(new int[]{4,5,6,7,8,1,3}, 0));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len <= 2) {
            int result = commonSearch(nums, target);
            return result >= 0 ? result : result;
        }

        int head = nums[0];
        int tail = nums[len - 1];

        // 如果头比尾小，那么序列是严格递增的
        if (head < tail) {
            int index = Arrays.binarySearch(nums, target);
            return index < 0 ? -1 : index;
        }

        int mid = nums[len / 2];

        // 前半部分是递增的
        if (mid > head) {
            if (target == mid) {
                return len / 2;
            } else if (target < mid && target >= head) {
                int[] newArray = new int[len / 2];
                System.arraycopy(nums, 0, newArray, 0, len / 2);
                return search(newArray, target);
            } else {
                int[] newArray = new int[len - len / 2 - 1];
                System.arraycopy(nums, len / 2 + 1, newArray, 0, len - len / 2 - 1);
                int index = search(newArray, target);
                return index < 0 ? -1 : index + len / 2 + 1;
            }
            // 后半部分是递增的
        } else {
            if (target == mid) {
                return len / 2;
            } else if (target > mid && target <= tail) {
                int[] newArray = new int[len - len / 2 - 1];
                System.arraycopy(nums, len / 2 + 1, newArray, 0, len - len / 2 - 1);
                int index = search(newArray, target);
                return index < 0 ? -1 : index + len / 2 + 1;
            } else {
                int[] newArray = new int[len / 2];
                System.arraycopy(nums, 0, newArray, 0, len / 2);
                return search(newArray, target);
            }
        }
    }

    private int commonSearch(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
