package Z161_180;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/19 16:53
 **/
public class MajorityElement169 {

    /**
     * 找出一个数组里面出现超过一半次数的数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            map.merge(nums[i], 1, Math::addExact);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
