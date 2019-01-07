package Z501_520;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/7 13:42
 **/
public class RelativeRanks506 {

    public String[] findRelativeRanks(int[] nums) {
        List<IndexAndNum> list = new ArrayList<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            IndexAndNum indexAndNum = new IndexAndNum();
            indexAndNum.num = nums[i];
            indexAndNum.index = i;
            list.add(indexAndNum);
        }

        list.sort((a, b) -> {return Integer.compare(b.num, a.num);});
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= list.size() - 1; i++) {
            map.put(list.get(i).index, i);
        }

        String[] result = new String[list.size()];
        for (int i = 0; i <= nums.length - 1; i++) {
            result[i] = change(map.get(i));
        }

        return result;
    }

    private String change(int num) {
        if (num == 0) {
            return "Gold Medal";
        } else if (num == 1) {
            return "Silver Medal";
        } else if (num == 2) {
            return "Bronze Medal";
        } else {
            return Integer.toString(num + 1);
        }
    }

    private class IndexAndNum {
        int num;
        int index;
    }
}
