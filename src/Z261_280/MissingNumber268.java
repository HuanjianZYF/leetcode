package Z261_280;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/20 15:14
 **/
public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] bucket = new int[len + 1];

        for (int num : nums) {
            bucket[num] = 1;
        }

        for (int i = 0; i <= len; i++) {
            if (bucket[i] == 0) {
                return i;
            }
        }

        return 0;
    }
}
