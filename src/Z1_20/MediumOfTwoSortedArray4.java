package Z1_20;

import java.util.Arrays;

/**
 * 寻找两个有序数组的中位数
 * @author zyf
 * @date 2018/9/17 下午7:55
 */
public class MediumOfTwoSortedArray4 {
	
	public static void main(String[] args) {
		System.out.println(new MediumOfTwoSortedArray4().findMedianSortedArrays(new int[]{1,2,3}, new int[]{0,1,2}));
	}

	/**
	 * 1. 分别拿到两个数组的中间的那个数
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		//如果某一个数组是空的，那就直接求另一个的中位数
		if (len1 == 0) {
			return getMedianInOneNum(nums2);
		}
		if (len2 == 0) {
			return getMedianInOneNum(nums1);
		}
		
		//如果两个的长度都小于5，那就变成一个数组吧，省的烦了
		if (len1 <= 5 && len2 <= 5) {
			return getMedianMerge(nums1, nums2);
		}
		
		//接下来进入正题
		
		return 0.0;
	}
	
	private double getMedianMerge(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		int[] nums = new int[len1 + len2];
		System.arraycopy(nums1, 0, nums, 0,  len1);
		System.arraycopy(nums2, 0, nums, len1,  len2);
		Arrays.sort(nums);
		
		return getMedianInOneNum(nums);
	}

	/**
	 * 在一个排好序的数组中拿到中位数 o(1)
	 * @param nums 排好序的数组
	 * @return 中位数
	 */
	private double getMedianInOneNum(int[] nums) {
		int length = nums.length;
		if (length % 2 == 1) {
			return nums[length / 2];
		} else {
			return (nums[length / 2] + nums[length / 2 - 1]) / 2.0;
		}
	}
}
