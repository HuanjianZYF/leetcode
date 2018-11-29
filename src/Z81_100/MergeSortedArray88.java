package Z81_100;

import java.util.Arrays;

/**
 * @Author wb-zyf471922
 * @Date 2018/11/29 13:38
 **/
public class MergeSortedArray88 {

    /**
     * 归并 合并咯
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i <= m + n - 1; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
}
