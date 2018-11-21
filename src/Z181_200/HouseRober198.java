package Z181_200;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/21 14:50
 **/
public class HouseRober198 {

    public static void main(String[] args) {
        System.out.println(new HouseRober198().rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    /**
     * 强盗抢屋子，不能抢连续的两家
     * 典型的递归问题，对于某一个数 分成两种情况，有这个数字和不是这个数字的，两路分治,,,,,结果TLE
     * 发现如果有某一个数大于两边的数的和，那么就可以将一个数组分成这个数，和两边的数组
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }

        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        if (len > 20) {
            for (int i = 2; i <= len - 3; i++) {
                if (nums[i] >= nums[i - 1] + nums[i + 1]) {
                    int[] array1 = new int[i - 1];
                    int[] array2 = new int[len - i - 2];
                    System.arraycopy(nums, 0, array1, 0, i - 1);
                    System.arraycopy(nums, i + 2, array2, 0, len - i - 2);
                    return nums[i] + rob(array1) + rob(array2);
                }
            }
        }

        return doRob(nums, nums.length);
    }

    private int doRob(int[] nums, int len) {
        // 递归出口
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }

        int num = nums[len - 1];
        int value1 = num + doRob(nums, len - 2);
        int value2 = doRob(nums, len - 1);

        return value1 > value2 ? value1 : value2;
    }
}
