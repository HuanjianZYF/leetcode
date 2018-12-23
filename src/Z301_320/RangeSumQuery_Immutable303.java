package Z301_320;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/23 13:33
 **/
public class RangeSumQuery_Immutable303 {

    private class NumArray {

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }

            return sum;
        }
    }
}
