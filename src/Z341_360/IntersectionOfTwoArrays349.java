package Z341_360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/18 19:16
 **/
public class IntersectionOfTwoArrays349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> resultList = new ArrayList<>();
        for (int num : nums1) {
            if (Arrays.binarySearch(nums2, num) >= 0 && !resultList.contains(num)) {
                resultList.add(num);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i <= resultList.size() - 1; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
