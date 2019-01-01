package Z481_500;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/1 18:20
 **/
public class MaxConsecutiveOnes485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int current = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                if (current > result) {
                    result = current;
                }
                current = 0;
            }
        }
        if (current > result) {
            result = current;
        }

        return result;
    }
}
