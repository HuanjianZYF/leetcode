package Z181_200;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/19 19:51
 **/
public class RotateArray189 {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i <= nums.length - 1; i++) {
            result[index++] = nums[i];
        }

        for (int i = 0; i < nums.length - k; i++) {
            result[index++] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
