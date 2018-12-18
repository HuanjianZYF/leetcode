package Z341_360;

import java.util.*;

/**
 * @Author wb-zyf471922
 * @Date 2018/12/18 19:29
 **/
public class IntersectionOfTwoArraysII350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> resultList = new ArrayList<>();
        int j = 0;
        int k = 0;
        while(j <= nums1.length - 1 && k <= nums2.length - 1) {
            if (nums1[j] == nums2[k]) {
                resultList.add(nums1[j]);
                j++;
                k++;
            } else if (nums1[j] < nums2[k]) {
                j++;
            } else {
                k++;
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i <= resultList.size() - 1; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
