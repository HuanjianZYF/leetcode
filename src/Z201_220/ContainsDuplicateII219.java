package Z201_220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/15 14:19
 **/
public class ContainsDuplicateII219 {

    /**
     * 数组中有没有相等的两个数 他们的距离最大为k
     * 1. 遍历数组获取一个map，key为值 value为下标的list
     * 2. 分析map，得到结果
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // 1. 获取map
        Map<Integer, List<Integer>> targetMap = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int num = nums[i];
            if (targetMap.get(num) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                targetMap.put(num, list);
            } else {
                List<Integer> list = targetMap.get(num);
                list.add(i);
            }
        }

        // 2. 分析
        for (Map.Entry<Integer, List<Integer>> entry : targetMap.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() == 1) {
                continue;
            } else {
                for (int i = 1; i <= value.size() - 1; i++) {
                    if (value.get(i) - value.get(i - 1) <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


}
