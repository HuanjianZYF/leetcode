package Z281_300;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/21 17:38
 **/
public class MoveZeros283 {

    public void moveZeroes(int[] nums) {
        int indexOfArray = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] != 0) {
                nums[indexOfArray++] = nums[i];
            }
        }

        for (int i = indexOfArray; i <= nums.length - 1; i++) {
            nums[i] = 0;
        }
    }
}
