package Z121_140;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/13 10:47
 **/
public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, 2);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
