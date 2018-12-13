package Z141_160;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/13 9:25
 **/
public class FindMinimunInRotatedSortedArray153 {

    /**
     * 在旋转升序序列找到最小的元素，按套路o(n)的肯定TLE了
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        if (size == 2) {
            return nums[0] < nums[1] ? nums[0] : nums[1];
        }

        int head = nums[0];
        int tail = nums[size - 1];
        if (head < tail) {
            return head;
        }

        int mid = nums[size / 2];
        if (mid < head) {
            int[] newArray = new int[size / 2 + 1];
            System.arraycopy(nums, 0, newArray, 0, size / 2 + 1);
            return findMin(newArray);
        } else {
            int[] newArray = new int[size - size / 2 - 1];
            System.arraycopy(nums, size / 2 + 1, newArray, 0, size - size / 2 - 1);
            return findMin(newArray);
        }
    }
}
