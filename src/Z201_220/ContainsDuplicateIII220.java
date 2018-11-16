package Z201_220;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/15 14:33
 **/
public class ContainsDuplicateIII220 {
    public static void main(String[] args) {
        int[] array = new int[]{0,10,22,15,0,5,22,12,1,5};
        //int[] array = new int[]{1, 3, 6, 2};
        System.out.println(new ContainsDuplicateIII220().containsNearbyAlmostDuplicate(
            array, 3, 3));
    }

    /**
     * 数组中有没有两个数的相差 <= t,且他们的下标 <= k
     * 1. 最笨的办法 两重循环 TLE了 o(n^2)
     * 2. 奢侈的办法，目标是得到一个map，譬如如果t=2，那么当数组的一个数字是5时，往map里面的3,4,5,6,7 的key的list中都加入这个index
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0) {
            return false;
        }
        int len = nums.length;

        if (t <= 100) {
            // 1. 获取map
            Map<Long, List<List<Integer>>> map = new HashMap<>();
            for (int i = 0; i <= nums.length - 1; i++) {
                for (long j = (long) nums[i] - t; j <= (long) nums[i]; j++) {
                    if (map.get(j) == null) {
                        List<List<Integer>> lists = new ArrayList<>();
                        List<Integer> list1 = new ArrayList<>();
                        List<Integer> list2 = new ArrayList<>();
                        lists.add(list1);
                        lists.add(list2);
                        map.put(j, lists);
                    }

                    map.get(j).get(0).add(i);
                }

                for (long j = (long) nums[i]; j <= (long) nums[i] + t; j++) {
                    if (map.get(j) == null) {
                        List<List<Integer>> lists = new ArrayList<>();
                        List<Integer> list1 = new ArrayList<>();
                        List<Integer> list2 = new ArrayList<>();
                        lists.add(list1);
                        lists.add(list2);
                        map.put(j, lists);
                    }

                    map.get(j).get(1).add(i);
                }
            }

            // 2. 分析map
            for (long num : nums) {
                List<Integer> list1 = map.get(num).get(0);
                if (list1.size() == 1) {
                } else {
                    for (int i = 1; i <= list1.size() - 1; i++) {
                        if (list1.get(i) - list1.get(i - 1) <= k) {
                            return true;
                        }
                    }
                }

                List<Integer> list2 = map.get(num).get(0);
                if (list2.size() == 1) {
                } else {
                    for (int i = 1; i <= list2.size() - 1; i++) {
                        if (list2.get(i) - list2.get(i - 1) <= k) {
                            return true;
                        }
                    }
                }
            }

            return false;
        } else {
            for (int i = 0; i <= len - 2; i++) {
                for (int j = i + 1; j <= i + k && j <= len - 1; j++) {
                    if (Math.abs((long) nums[j] - (long) nums[i]) <= t) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
