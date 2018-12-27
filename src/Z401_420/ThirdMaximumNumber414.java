package Z401_420;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/27 17:16
 **/
public class ThirdMaximumNumber414 {

    public int thirdMax(int[] nums) {

        Integer max = null;
        Integer second = null;
        Integer third = null;
        for (int num : nums) {
            if (max == null || num > max) {
                third = second;
                second = max;
                max = num;
            } else if (num < max && (second == null || num > second)) {
                third = second;
                second = num;
            } else if (second != null && num < second && (third == null || num > third)) {
                third = num;
            }
        }

        return third == null ? max : third;
    }
}
