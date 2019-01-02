package Z481_500;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2019/1/2 17:11
 **/
public class NextGreaterElementI496 {

    public static void main(String[] args) {
        System.out.println(new NextGreaterElementI496().nextGreaterElement(new int[]{4,1,2}, new int[]{4,1,3,2}));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> waitList = new ArrayList<>();
        for (int i = 0; i <= nums2.length - 1; i++) {
            for (Iterator<Integer> iterator = waitList.iterator(); iterator.hasNext();) {
                Integer value = iterator.next();
                if (value < nums2[i]) {
                    map.put(value, nums2[i]);
                    iterator.remove();
                }
            }
            waitList.add(nums2[i]);
        }
        for (Integer num : waitList) {
            map.put(num, -1);
        }

        for (int i = 0; i <= nums1.length - 1; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
