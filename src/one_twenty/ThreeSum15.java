package one_twenty;

import java.util.*;

/**
 * @author zyf
 * @date 2018/9/18 下午4:53
 */
public class ThreeSum15 {
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,-2,-1};
		long t1 = System.nanoTime();
		System.out.println(new ThreeSum15().threeSum(array));
		long t2 = System.nanoTime();
		System.out.println(t2 - t1);
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		if (nums == null || nums.length < 3) {
			return result;
		}

		Arrays.sort(nums);
		for (int i = 0; i <= nums.length - 3; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int value = nums[i];

				List<List<Integer>> subList = findTwoSum(Arrays.copyOfRange(nums, i + 1, nums.length), -value);
				for (List<Integer> each : subList) {
					each.add(value);
					result.add(each);
				}
			}
		}
		
		return result;
	}
	
	private List<List<Integer>> findTwoSum(int[] nums, int sum) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i <= nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int value = nums[i];
				Integer a = searchOne(nums, i, sum - value);
				if (a != null) {
					List<Integer> list = new ArrayList<>();
					list.add(value);
					list.add(a);
					result.add(list);
				}
			}
		}
		
		return result;
	}
	
	private Integer searchOne(int[] nums, int i, int target) {
		int index = Arrays.binarySearch(nums, i + 1, nums.length, target);
		
		return index >= 0 ? target : null;
	}
}
